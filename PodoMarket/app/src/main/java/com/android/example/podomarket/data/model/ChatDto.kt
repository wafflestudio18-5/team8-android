package com.android.example.podomarket.data.model

data class ChatRoomDto(
    val id: Int = -1,
    val otherUserNickname: String = "Anonymous",
    val otherUserImageUrl: String? = null,
    val productImageUrl: String? = null,
    val lastMessageSent: String = "",
    val existNewMessage: Boolean = false,
    val productId: Int = -1,
    val otherUserId: Int = -1
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