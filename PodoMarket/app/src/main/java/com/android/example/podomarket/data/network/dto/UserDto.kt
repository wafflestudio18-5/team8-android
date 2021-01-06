package com.android.example.podomarket.data.network.dto

// TODO
// Should add badges, Products_bought, Products_sold
data class UserDto(
    val user_id: Int,
    val full_name: String,
    val nickname: String,
    val image: String,
    val temperature: Double,
    val token: String
)

data class CityDto(
    val city_id: Int,
    val name: String,
    val location: String
)