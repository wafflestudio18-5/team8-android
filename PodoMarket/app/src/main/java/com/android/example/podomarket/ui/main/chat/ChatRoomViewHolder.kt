package com.android.example.podomarket.ui.main.chat

import androidx.recyclerview.widget.RecyclerView
import com.android.example.podomarket.data.model.ChatRoomDto
import com.android.example.podomarket.databinding.ItemChatRoomBinding
import com.android.example.podomarket.ui.chat.ChatRoomActivity

class ChatRoomViewHolder(private val binding: ItemChatRoomBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindItems(chatRoomDto: ChatRoomDto) {
        binding.run {
            chatRoom = chatRoomDto
            chatRoomContainer.setOnClickListener {
                binding.root.context.startActivity(
                    ChatRoomActivity.intentWithProductIdAndUserId(
                        chatRoomDto.productId,
                        chatRoomDto.otherUserId,
                        binding.root.context
                    )
                )
            }
        }
    }
}