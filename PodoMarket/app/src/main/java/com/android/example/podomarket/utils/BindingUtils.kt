package com.android.example.podomarket.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.podomarket.R
import com.android.example.podomarket.data.model.ChatMessageDto
import com.android.example.podomarket.data.model.ChatRoomDto
import com.android.example.podomarket.data.network.dto.LikeProductDto
import com.android.example.podomarket.data.network.dto.ProductDto
import com.android.example.podomarket.ui.chat.ChatListAdapter
import com.android.example.podomarket.ui.main.chat.ChatRoomListAdapter
import com.android.example.podomarket.ui.main.product.ProductListAdapter
import com.bumptech.glide.Glide

@BindingAdapter("existNewMessage")
fun bindAlertItem(view: CardView, bool: Boolean) {
    if (bool)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.INVISIBLE
}

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
fun bindProductListItems(view: RecyclerView, items: List<ProductDto>?) {
    val adapter = view.adapter as ProductListAdapter
    items?.let { adapter.setItems(it) }
}

@BindingAdapter("bindSoldOutText")
fun bindSoldOutText(view: CardView, status: Int) {
    when (status) {
        0 -> view.visibility = View.VISIBLE // SOLD_OUT
        else -> view.visibility = View.GONE
    }
}