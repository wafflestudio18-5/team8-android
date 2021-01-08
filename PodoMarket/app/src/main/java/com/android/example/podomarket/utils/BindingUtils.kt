package com.android.example.podomarket.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.podomarket.R
import com.android.example.podomarket.data.model.ChatMessageDto
import com.android.example.podomarket.data.model.ChatRoomDto
import com.android.example.podomarket.data.network.dto.ProductDto
import com.android.example.podomarket.ui.chat.ChatListAdapter
import com.android.example.podomarket.ui.main.chat.ChatRoomListAdapter
import com.android.example.podomarket.ui.main.product.ProductListAdapter
import com.bumptech.glide.Glide

@BindingAdapter("messages")
fun bindChatMessageItems(view: RecyclerView, items: List<ChatMessageDto>?) {
    val adapter = view.adapter as ChatListAdapter
    adapter.submitList(items)
}

@BindingAdapter("chatRooms")
fun bindChatRoomItems(view: RecyclerView, items: List<ChatRoomDto>?) {
    val adapter = view.adapter as ChatRoomListAdapter
    adapter.submitList(items)
}

@BindingAdapter("setPersonImageUrl")
fun bindPersonImageUrl(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load(url)
        .placeholder(R.drawable.ic_baseline_person_24)
        .into(view)
}

@BindingAdapter("setProductImageUrl")
fun bindProductImageUrl(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load(url)
        .placeholder(R.drawable.ic_baseline_image_24)
        .into(view)
}

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("bindProductListItems")
fun bindProductListItems(view: RecyclerView, items: List<ProductDto>) {
    val adapter = view.adapter as ProductListAdapter
    adapter.setItems(items)
}