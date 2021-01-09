package com.android.example.podomarket.ui.main.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.podomarket.data.model.ChatRoomDto
import com.android.example.podomarket.data.repo.UserRepository
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

class ChatRoomListViewModel(private val userRepository: UserRepository) : ViewModel() {

    val _chatRooms = MutableLiveData<List<ChatRoomDto>>()
    val chatRooms: LiveData<List<ChatRoomDto>>
        get() = _chatRooms

    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val databaseReference = firebaseDatabase.reference

    fun getChatRooms() {
        databaseReference.child("chats").child(userRepository.getMyInfo()?.id.toString())
            .addChildEventListener(
                object : ChildEventListener {
                    override fun onCancelled(error: DatabaseError) {
                    }

                    override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                    }

                    override fun onChildChanged(
                        snapshot: DataSnapshot,
                        previousChildName: String?
                    ) {
                    }

                    override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                        if (_chatRooms.value == null)
                            _chatRooms.value = listOf(
                                snapshot.getValue(ChatRoomDto::class.java)!!
                            )
                        else {
                            val tmpList = _chatRooms.value!!.toMutableList()
                            tmpList.add(snapshot.getValue(ChatRoomDto::class.java)!!)
                            _chatRooms.value = tmpList
                        }
                    }

                    override fun onChildRemoved(snapshot: DataSnapshot) {
                    }

                }
            )
    }

    fun clearChatRooms() {
        _chatRooms.value = null

    }
}