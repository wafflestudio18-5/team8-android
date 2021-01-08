package com.android.example.podomarket.ui.chat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.data.repo.UserRepository
import com.android.example.podomarket.databinding.ActivityChatRoomBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ChatRoomActivity : AppCompatActivity() {

    private val chatRoomViewModel: ChatRoomViewModel by viewModel()
    private val userRepository: UserRepository by inject()

    private val binding: ActivityChatRoomBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_chat_room
        ) as ActivityChatRoomBinding
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chatRoomViewModel.apply {
            chatRoomId = intent.getIntExtra(CHAT_ROOM_ID, -1)
            getUsersInfo(intent.getIntExtra(USER_ID, -1))
        }
        binding.run {
            viewModel = chatRoomViewModel
            lifecycleOwner = this@ChatRoomActivity
            toolBar.also { tb ->
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
                tb.inflateMenu(R.menu.app_bar_activity_chat_room)
                tb.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.more_button -> Toast.makeText(
                            applicationContext,
                            "추가 기능 미완성",
                            Toast.LENGTH_SHORT
                        ).show()
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
            userInfoLayout.setOnClickListener {
                //startActivity(ProfileActivity.intentWithUserId(chatRoomViewModel.userId, this@ChatRoomActivity))
            }
            productInfoLayout.setOnClickListener {
                //startActivity(ProductDetailActivity.intentWithProductId(chatRoomViewModel.productId, this@ChatRoomActivity))
            }
            chatListView.adapter = ChatListAdapter(userRepository.getMyInfo()!!.id)
        }
    }

    //Need product info too
    companion object {
        private const val CHAT_ROOM_ID = "chat_room_id"
        private const val USER_ID = "user_id"

        fun intentWithChatRoomIdAndUserId(
            chat_room_id: Long,
            user_id: Int,
            context: Context
        ): Intent =
            Intent(context, ChatRoomActivity::class.java).apply {
                putExtra(
                    CHAT_ROOM_ID,
                    chat_room_id
                )
                putExtra(
                    USER_ID,
                    user_id
                )
            }
    }
}