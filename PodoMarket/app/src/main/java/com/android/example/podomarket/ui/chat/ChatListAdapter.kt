package com.android.example.podomarket.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.podomarket.data.model.ChatMessageDto
import com.android.example.podomarket.databinding.ItemMyMsgboxBinding
import com.android.example.podomarket.databinding.ItemOtherMsgboxBinding

class ChatListAdapter() :
    ListAdapter<ChatMessageDto, RecyclerView.ViewHolder>(ChatMessageDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            MY_MESSAGE_VIEW_TYPE ->
                ChatMyMessageViewHolder(
                    ItemMyMsgboxBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            OTHER_MESSAGE_VIEW_TYPE ->
                ChatOtherMessageViewHolder(
                    ItemOtherMsgboxBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            else -> throw IllegalStateException("View type error")
        }
   

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ChatMyMessageViewHolder -> holder.bindItems(getItem(position))
            is ChatOtherMessageViewHolder -> holder.bindItems(getItem(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        // TODO replace 0 with user id from preference
        return if (getItem(position).sender.id == 0)
            MY_MESSAGE_VIEW_TYPE
        else
            OTHER_MESSAGE_VIEW_TYPE

    }

    companion object {
        private const val MY_MESSAGE_VIEW_TYPE = 0
        private const val OTHER_MESSAGE_VIEW_TYPE = 1
    }
}

class ChatMessageDiffCallback : DiffUtil.ItemCallback<ChatMessageDto>() {
    override fun areItemsTheSame(oldItem: ChatMessageDto, newItem: ChatMessageDto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ChatMessageDto, newItem: ChatMessageDto): Boolean {
        return oldItem == newItem
    }

}