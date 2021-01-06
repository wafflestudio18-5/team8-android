package com.android.example.podomarket.data.model

data class ChatRoomDto(
    val id: Int,
    val members: List<ChatUserDto>,
    val lastMessageSent: ChatMessageDto
)

data class ChatUserDto(
    val id: Int,
    val nickname: String = "Anonymous",
    val imageUrl: String?,
)

data class ChatMessageDto(
    val id: Int,
    val sender: ChatUserDto,
    val message: String,
    val timestamp: String
)