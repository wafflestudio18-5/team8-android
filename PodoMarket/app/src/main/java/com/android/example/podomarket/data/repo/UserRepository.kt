package com.android.example.podomarket.data.repo

import android.content.SharedPreferences
import com.android.example.podomarket.data.network.dto.UserDto
import com.android.example.podomarket.data.network.service.UserService
import com.google.gson.Gson
import io.reactivex.rxjava3.schedulers.Schedulers

class UserRepository(val sp: SharedPreferences, val service: UserService) {

    fun getUserInfo(user_id: Int) = service.getUserById(user_id)

    fun getMyInfo(): UserDto? {
        var userDto: UserDto? = null
        val json = sp.getString("user_info", null)

        if (json != null) { // load from memory
            userDto = Gson().fromJson(json, UserDto::class.java)
        } else { // load from network
            val singleResponse = service.getUserMe()
            singleResponse
                .subscribeOn(Schedulers.io())
                .subscribe { response ->
                    userDto = response.body()
                    val json = Gson().toJson(userDto)
                    sp.edit().putString("user_info", json).apply() // save to memory
                }
        }
        return userDto
    }

}