package com.android.example.podomarket.ui.chat

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
            toolBar.also { tb ->
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
                tb.inflateMenu(R.menu.app_bar_activity_chat_room)
                tb.setOnMenuItemClickListener {
                    when(it.itemId) {
                        R.id.more_button -> Toast.makeText(applicationContext, "추가 기능 미완성", Toast.LENGTH_SHORT)
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
        }
    }
}