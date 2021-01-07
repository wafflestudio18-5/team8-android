package com.android.example.podomarket.data.repo

import android.content.SharedPreferences
import com.android.example.podomarket.data.network.dto.UserDto
import com.android.example.podomarket.data.network.service.UserService
import com.android.example.podomarket.di.NetworkConst.TOKEN_KEY
import com.android.example.podomarket.di.NetworkConst.USER_INFO_KEY
import com.google.gson.Gson
import io.reactivex.rxjava3.schedulers.Schedulers

class UserRepository(private val sp: SharedPreferences, private val service: UserService) {

    fun getUserInfo(user_id: Int) = service.getUserById(user_id)

    fun postMyInfo(accessToken: String, social: String): UserDto? {
        var userDto: UserDto? = null
        // load from network
        val singleResponse = service.postUser(accessToken, social)
        singleResponse
            .subscribeOn(Schedulers.io())
            .subscribe { response ->
                userDto = response.body()
                val newJson = Gson().toJson(userDto)
                val editor = sp.edit()
                editor.putString(USER_INFO_KEY, newJson) // save to memory
                editor.putString(TOKEN_KEY, userDto?.token)
                editor.apply()
            }

        return userDto
    }

    fun getMyInfo(): UserDto? {
        return sp.getString(USER_INFO_KEY, null)?.let {
            Gson().fromJson(it, UserDto::class.java)
        }
    }

    fun existMyToken(): String? =
        sp.getString(TOKEN_KEY, null)

    fun deleteMyInfo() {
        val editor = sp.edit()
        editor.remove(USER_INFO_KEY)
        editor.remove(TOKEN_KEY)
        editor.apply()
    }

}