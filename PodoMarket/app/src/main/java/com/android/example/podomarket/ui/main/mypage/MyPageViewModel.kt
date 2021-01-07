package com.android.example.podomarket.ui.main.mypage

import androidx.lifecycle.ViewModel
import com.android.example.podomarket.data.repo.UserRepository

class MyPageViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun logout() {
        userRepository.deleteMyInfo()
    }
}