package com.android.example.podomarket.data.network.dto

data class ProductDto(
    val id: Int,
    val name: String,
    val category: String,
    val price: Int,
    val allow_suggest: Boolean,
    val status: String,
    val distance_range: Int,
    val city_id: Int,
    val seller: Int,
    val buyer: Int?,
    val count_comments: Int,
    val count_likes: Int,
    val count_views: Int,
    val images: List<String>?,
    val like_product: List<LikeProductDto>?
)

data class LikeProductDto(
    val id: Int,
    val profile: Int,
    val product: Int,
    val active: Boolean
)

data class SuggestPriceDto(
    val id: Int,
    val will_buyer: Int,
    val confirm: Boolean,
    val product: Int,
    val suggest_price: Int
)

data class PaginationResponse(
    val page: PageDto,
    val products: List<ProductDto>
)

data class PageDto(
    val product_count: Int,
    val page_count: Int,
    val current_page: Int
)

data class ChatRoomDto(
    val id: Int,
    val will_buyer: Int,
    val is_active: Boolean,
    val product: Int
)

data class TransactionDto(
    val id: Int,
    val chatroom: Int,
    val buyer_review: Int,
    val seller_review: Int
)