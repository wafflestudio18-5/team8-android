package com.android.example.podomarket.di

import com.android.example.podomarket.ui.main.mypage.MyPageViewModel
import com.android.example.podomarket.ui.user.login.LoginViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { LoginViewModel(get()) }
    single { MyPageViewModel(get()) }
}
