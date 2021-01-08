package com.android.example.podomarket.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.podomarket.data.model.ChatMessageDto
import com.android.example.podomarket.data.model.ChatUserDto
import com.android.example.podomarket.data.repo.UserRepository
import com.google.firebase.database.FirebaseDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber

class ChatRoomViewModel(private val userRepository: UserRepository) : ViewModel() {


    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val databaseReference = firebaseDatabase.reference
    var chatRoomId: Int = -1

    private val _chatUserMe = MutableLiveData<ChatUserDto>()
    val chatUserMe: LiveData<ChatUserDto>
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
            if (_messages.value == null)
                _messages.value = listOf<ChatMessageDto>(
                    ChatMessageDto(
                        0,
                        chatUserMe.value!!,
                        it,
                        "11:47"
                    )
                )
            else {
                val tmpList = _messages.value?.toMutableList()
                val num = tmpList!!.size
                tmpList.add(ChatMessageDto(num, chatUserMe.value!!, it, "11:47"))
                _messages.value = tmpList
            }

        }
        message.value = null
    }

}