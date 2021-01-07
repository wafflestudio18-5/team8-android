package com.android.example.podomarket.ui.user.login

import androidx.lifecycle.ViewModel
import com.android.example.podomarket.data.repo.UserRepository

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun signInUser(accessToken: String, social: String) {
        userRepository.postMyInfo(accessToken, social)
    }

    fun isLoggedIn(): Boolean =
        userRepository.existMyToken() != null

}