package com.android.example.podomarket.data.model

import android.content.Context
import com.android.example.podomarket.data.model.UserInfoConstants.FULL_NAME
import com.android.example.podomarket.data.model.UserInfoConstants.IMAGE
import com.android.example.podomarket.data.model.UserInfoConstants.NICKNAME
import com.android.example.podomarket.data.model.UserInfoConstants.PREF_NAME
import com.android.example.podomarket.data.model.UserInfoConstants.TEMPERATURE
import com.android.example.podomarket.data.model.UserInfoConstants.TOKEN
import com.android.example.podomarket.data.model.UserInfoConstants.USER_ID
import com.android.example.podomarket.data.network.dto.UserDto

class UserInfo(context: Context) {
    val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun save(userDto: UserDto) {
        val editor = sp.edit()

        if (userDto != null) {
            editor.putInt(USER_ID, userDto.user_id)
                .putString(FULL_NAME, userDto.full_name)
                .putString(NICKNAME, userDto.nickname)
                .putString(IMAGE, userDto.image)
                .putFloat(TEMPERATURE, userDto.temperature.toFloat())
                .putString(TOKEN, userDto.token)
                .apply()
        }
    }

    fun load(): UserDto {
        val user_id = sp.getInt(USER_ID, 0)
        val full_name = sp.getString(FULL_NAME, "")!!
        val nickname = sp.getString(NICKNAME, "")!!
        val image = sp.getString(IMAGE, "")!!
        val temperature = sp.getFloat(TEMPERATURE, 0F).toDouble()
        val token = sp.getString(TOKEN, "")!!

        return UserDto(user_id, full_name, nickname, image, temperature, token)
    }

}

object UserInfoConstants {
    // SharedPreferences Name
    const val PREF_NAME = "user_info_pref"
    // Value Key
    const val USER_ID = "user_id"
    const val FULL_NAME = "full_name"
    const val NICKNAME = "nickname"
    const val IMAGE = "image"
    const val TEMPERATURE = "temperature"
    const val TOKEN = "token"
}