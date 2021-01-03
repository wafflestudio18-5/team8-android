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

class UserInfo(val userDto: UserDto) {
    var user_id: Int = 0
    var full_name: String = ""
    var nickname: String = ""
    var image: String = ""
    var temperature: Float = 0F
    var token: String = ""

    fun save(context: Context) {
        val sp = context.getSharedPreferences(PREF_NAME, 0)
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

    fun load(context: Context) {
        val sp = context.getSharedPreferences(PREF_NAME, 0)
        user_id = sp.getInt(USER_ID, 0)
        full_name = sp.getString(FULL_NAME, "")!!
        nickname = sp.getString(NICKNAME, "")!!
        image = sp.getString(IMAGE, "")!!
        temperature = sp.getFloat(TEMPERATURE, 0F)
        token = sp.getString(TOKEN, "")!!
    }

}

object UserInfoConstants {
    const val PREF_NAME = "user_info_pref"

    const val USER_ID = "user_id"
    const val FULL_NAME = "full_name"
    const val NICKNAME = "nickname"
    const val IMAGE = "image"
    const val TEMPERATURE = "temperature"
    const val TOKEN = "token"
}