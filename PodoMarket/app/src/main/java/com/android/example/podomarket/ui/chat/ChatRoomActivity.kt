package com.android.example.podomarket.ui.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.example.podomarket.R
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.databinding.ActivityChatRoomBinding

class ChatRoomActivity : AppCompatActivity() {
    private val binding: ActivityChatRoomBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_chat_room
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {

        }
    }
}