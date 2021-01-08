package com.android.example.podomarket.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.podomarket.data.model.ChatMessageDto
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

    fun sendMessage() {
        message.value?.let {
            databaseReference.child("message").child(chatRoomId).push().setValue(
                ChatMessageDto(0, chatUserMe.value!!, it, getCurrentTimeAsString())
            )
        }
        message.value = null
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

                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                }

            }
        )
    }

    fun clearMessages() {
        _messages.value = null
    }

    fun generateChatRoomId(otherUserId: Int, productId: Int) {
        val myUserId = chatUserMe.value!!.id
        val tmp: String = if (myUserId < otherUserId) myUserId.toString() + "_" + otherUserId
        else otherUserId.toString() + "_" + myUserId.toString()
        chatRoomId = tmp + "_" + productId.toString()
    }

    private fun getCurrentTimeAsString(): String = df.format(Calendar.getInstance().time)

}