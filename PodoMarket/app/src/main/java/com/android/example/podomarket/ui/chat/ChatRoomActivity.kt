package com.android.example.podomarket.ui.chat

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.example.podomarket.R
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.databinding.ActivityChatRoomBinding

class ChatRoomActivity : AppCompatActivity() {
    companion object {
        fun intentWithChatRoomId(chatRoomId: Long, context: Context): Intent = Intent(context, ChatRoomActivity::class.java)
    }

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