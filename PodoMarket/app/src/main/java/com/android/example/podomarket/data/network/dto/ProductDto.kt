package com.android.example.podomarket.data.network.dto

data class ProductDto(
    val product_id: Int,
    val name: String,
    val category: Int,
    val price: Int,
    val allow_suggest: Boolean,
    val distance_range: DistanceRange,
    val city_id: Int,
    val seller: Int,
    val buyer: Int,
    val count_comments: Int,
    val count_likes: Int,
    val count_views: Int
)

data class DistanceRange(
    val x: Int,
    val y: Int,
    val z: Int
)