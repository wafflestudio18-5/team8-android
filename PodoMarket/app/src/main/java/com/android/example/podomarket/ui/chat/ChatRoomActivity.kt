package com.android.example.podomarket.ui.chat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.example.podomarket.R
import com.android.example.podomarket.data.repo.UserRepository
import com.android.example.podomarket.databinding.ActivityChatRoomBinding
import com.android.example.podomarket.ui.product.detail.ProductDetailActivity
import com.android.example.podomarket.ui.user.profile.ProfileActivity
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
        val productId = intent.getIntExtra(PRODUCT_ID, -1)
        val otherUserId = intent.getIntExtra(USER_ID, -1)
        chatRoomViewModel.apply {
            getUsersInfo(otherUserId)
            getProductInfo(productId)
            generateChatRoomId(otherUserId, productId)
        }
        val chatListAdapter = ChatListAdapter(userRepository.getMyInfo()!!.id)
        val linearLayoutManager = LinearLayoutManager(this)
        binding.run {
            viewModel = chatRoomViewModel
            lifecycleOwner = this@ChatRoomActivity
            chatListView.adapter = chatListAdapter
            chatListView.layoutManager = linearLayoutManager
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
                startActivity(ProfileActivity.intentWithUserId(otherUserId, this@ChatRoomActivity))
            }
            productInfoLayout.setOnClickListener {
                startActivity(
                    ProductDetailActivity.intentWithProductId(
                        productId,
                        this@ChatRoomActivity
                    )
                )
            }
            sendButton.setOnClickListener {
                chatRoomViewModel.sendMessage()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        chatRoomViewModel.readUnreadMessages()
        chatRoomViewModel.getMessage()

    }

    override fun onPause() {
        chatRoomViewModel.clearMessages()
        super.onPause()
    }

    companion object {
        private const val PRODUCT_ID = "product_id"
        private const val USER_ID = "user_id"

        fun intentWithProductIdAndUserId(
            product_id: Int,
            user_id: Int,
            context: Context
        ): Intent =
            Intent(context, ChatRoomActivity::class.java).apply {
                putExtra(
                    PRODUCT_ID,
                    product_id
                )
                putExtra(
                    USER_ID,
                    user_id
                )
            }
    }
}