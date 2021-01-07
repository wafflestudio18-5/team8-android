package com.android.example.podomarket.ui.chat

import androidx.recyclerview.widget.RecyclerView
import com.android.example.podomarket.data.model.ChatMessageDto
import com.android.example.podomarket.databinding.ItemMyMsgboxBinding
import com.android.example.podomarket.databinding.ItemOtherMsgboxBinding

class ChatMyMessageViewHolder(private val binding: ItemMyMsgboxBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindItems(chatMessageDto: ChatMessageDto) {
        binding.run {
            chatMessage = chatMessageDto
        }
    }

}

class ChatOtherMessageViewHolder(private val binding: ItemOtherMsgboxBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindItems(chatMessageDto: ChatMessageDto) {
        binding.run {
            chatMessage = chatMessageDto
        }
    }

}