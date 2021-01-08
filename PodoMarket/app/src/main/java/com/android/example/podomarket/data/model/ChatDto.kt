package com.android.example.podomarket.data.model

data class ChatRoomDto(
    val id: Int,
    val otherUser: ChatUserDto,
    val meUser: ChatUserDto,
    val productImageUrl: String?,
    val lastMessageSent: ChatMessageDto
)

data class ChatUserDto(
    val id: Int = -1,
    val nickname: String = "Anonymous",
    val city: String? = null,
    val imageUrl: String? = null,
)

data class ChatMessageDto(
    val id: Int = -1,
    val sender: ChatUserDto = ChatUserDto(),
    val message: String = "",
    val timestamp: String = ""
)