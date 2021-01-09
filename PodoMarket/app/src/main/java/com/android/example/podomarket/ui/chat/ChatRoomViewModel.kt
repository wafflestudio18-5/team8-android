package com.android.example.podomarket.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.podomarket.data.model.ChatMessageDto
import com.android.example.podomarket.data.model.ChatRoomDto
import com.android.example.podomarket.data.model.ChatUserDto
import com.android.example.podomarket.data.repo.ProductRepository
import com.android.example.podomarket.data.repo.UserRepository
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class ChatRoomViewModel(
    private val userRepository: UserRepository,
    private val productRepository: ProductRepository
) : ViewModel() {


    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val databaseReference = firebaseDatabase.reference
    private var chatRoomId: String = ""
    private val df: DateFormat = SimpleDateFormat("MM.dd 'at' HH:mm", Locale.KOREA)
    private var messageNum: Int = 0

    private val _productImageUrl = MutableLiveData<String>()
    val productImageUrl: LiveData<String>
        get() = _productImageUrl
    private val _productName = MutableLiveData<String>()
    val productName: LiveData<String>
        get() = _productName
    private val _productPrice = MutableLiveData<String>()
    val productPrice: LiveData<String>
        get() = _productPrice
    private val _chatUserMe = MutableLiveData<ChatUserDto>()
    private val chatUserMe: LiveData<ChatUserDto>
        get() = _chatUserMe
    private val _chatUserOther = MutableLiveData<ChatUserDto>()
    val chatUserOther: LiveData<ChatUserDto>
        get() = _chatUserOther
    private val _messages = MutableLiveData<List<ChatMessageDto>>()
    val messages: LiveData<List<ChatMessageDto>>
        get() = _messages
    val message = MutableLiveData<String>()

    fun getUsersInfo(userOtherId: Int) {
        userRepository.getUserInfo(userOtherId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                val userOther = response.body()
                // city 구현 불가
                _chatUserOther.value =
                    ChatUserDto(userOther!!.id, userOther.nickname, null, userOther.image)
            }, {
                Timber.e(it)
            })
        val userMe = userRepository.getMyInfo()
        _chatUserMe.value = ChatUserDto(userMe!!.id, userMe.nickname, null, userMe.image)
    }

    fun getProductInfo(productId: Int) {
        productRepository.getProductById(productId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response.body()?.images?.size != 0)
                    _productImageUrl.value = response.body()?.images?.first()?.image_url
                _productName.value = response.body()?.name
                _productPrice.value = response.body()?.price.toString()
            }, {
                Timber.e(it)
            })
    }

    fun sendMessage() {
        try {
            message.value?.let {
                databaseReference.child("message").child(chatRoomId).push().setValue(
                    ChatMessageDto(messageNum, chatUserMe.value!!, it, getCurrentTimeAsString())
                )
                databaseReference.child("chats").child(chatUserMe.value!!.id.toString())
                    .child(chatRoomId).setValue(
                        ChatRoomDto(
                            messageNum,
                            chatUserOther.value!!.nickname,
                            chatUserOther.value!!.imageUrl,
                            productImageUrl.value,
                            it,
                            false
                        )
                    )
                databaseReference.child("chats").child(chatUserOther.value!!.id.toString())
                    .child(chatRoomId).setValue(
                        ChatRoomDto(
                            messageNum,
                            chatUserMe.value!!.nickname,
                            chatUserMe.value!!.imageUrl,
                            productImageUrl.value,
                            it,
                            true
                        )
                    )
            }
            message.value = null
        } catch (e: NullPointerException) {
            Timber.e(e)
        }
    }

    fun getMessage() {
        databaseReference.child("message").child(chatRoomId).addChildEventListener(
            object : ChildEventListener {
                override fun onCancelled(error: DatabaseError) {
                }

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                }

                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    if (_messages.value == null)
                        _messages.value = listOf<ChatMessageDto>(
                            snapshot.getValue(ChatMessageDto::class.java)!!
                        )
                    else {
                        val tmpList = _messages.value?.toMutableList()
                        tmpList?.add(snapshot.getValue(ChatMessageDto::class.java)!!)
                        _messages.value = tmpList
                    }
                    messageNum++
                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                }

            }
        )
    }

    fun readUnreadMessages() {
        val ref = databaseReference.child("chats").child(chatUserMe.value!!.id.toString())
            .child(chatRoomId)
        ref.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(error: DatabaseError) {
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
            }

            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                if (snapshot.hasChild("existNewMessage"))
                    ref.setValue(false)
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
            }

        })
    }

    fun clearMessages() {
        _messages.value = null
        messageNum = 0
    }

    fun generateChatRoomId(otherUserId: Int, productId: Int) {
        val myUserId = chatUserMe.value!!.id
        val tmp: String = if (myUserId < otherUserId) myUserId.toString() + "_" + otherUserId
        else otherUserId.toString() + "_" + myUserId.toString()
        chatRoomId = tmp + "_" + productId.toString()
    }

    private fun getCurrentTimeAsString(): String = df.format(Calendar.getInstance().time)

}