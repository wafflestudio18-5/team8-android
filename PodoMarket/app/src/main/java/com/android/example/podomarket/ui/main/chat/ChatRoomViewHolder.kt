package com.android.example.podomarket.ui.main.chat

import androidx.recyclerview.widget.RecyclerView
import com.android.example.podomarket.data.model.ChatRoomDto
import com.android.example.podomarket.databinding.ItemChatRoomBinding

class ChatRoomViewHolder(private val binding: ItemChatRoomBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindItems(chatRoomDto: ChatRoomDto) {
        binding.run {
            chatRoom = chatRoomDto
        }
    }
}