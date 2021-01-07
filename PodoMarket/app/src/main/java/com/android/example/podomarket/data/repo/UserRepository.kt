package com.android.example.podomarket.data.repo

import android.content.SharedPreferences
import com.android.example.podomarket.data.network.dto.UserDto
import com.android.example.podomarket.data.network.service.UserService
import com.google.gson.Gson
import io.reactivex.rxjava3.schedulers.Schedulers

class UserRepository(private val sp: SharedPreferences, private val service: UserService) {

    fun getUserInfo(user_id: Int) = service.getUserById(user_id)

    fun getMyInfo(): UserDto? {
        var userDto: UserDto? = null
        val json = sp.getString(USER_INFO, null)

        if (json != null) { // load from memory
            userDto = Gson().fromJson(json, UserDto::class.java)
        } else { // load from network
            val singleResponse = service.getUserMe()
            singleResponse
                .subscribeOn(Schedulers.io())
                .subscribe { response ->
                    userDto = response.body()
                    val newJson = Gson().toJson(userDto)
                    sp.edit().putString(USER_INFO, newJson).apply() // save to memory
                }
        }
        return userDto
    }

    companion object {
        const val USER_INFO = "user_info"
    }
}