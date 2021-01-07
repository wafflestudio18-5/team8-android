package com.android.example.podomarket.ui.main.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.podomarket.data.model.ChatRoomDto
import com.android.example.podomarket.databinding.ItemChatRoomBinding

class ChatRoomListAdapter() :
    ListAdapter<ChatRoomDto, RecyclerView.ViewHolder>(ChatRoomDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ChatRoomViewHolder(
            ItemChatRoomBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ChatRoomViewHolder).bindItems(getItem(position))
    }

}

class ChatRoomDiffCallback : DiffUtil.ItemCallback<ChatRoomDto>() {
    override fun areItemsTheSame(oldItem: ChatRoomDto, newItem: ChatRoomDto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ChatRoomDto, newItem: ChatRoomDto): Boolean {
        return oldItem == newItem
    }
}