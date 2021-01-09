package com.android.example.podomarket.ui.main.mypage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.podomarket.data.network.dto.UserDto
import com.android.example.podomarket.data.repo.UserRepository

class MyPageViewModel(private val userRepository: UserRepository) : ViewModel() {

    val myInfo = MutableLiveData<UserDto>(userRepository.getMyInfo())

    fun logout() {
        userRepository.deleteMyInfo()
    }

    fun getMyInfo() = userRepository.getMyInfo()

}