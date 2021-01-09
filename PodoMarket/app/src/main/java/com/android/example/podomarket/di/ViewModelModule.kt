package com.android.example.podomarket.di

import com.android.example.podomarket.ui.chat.ChatRoomViewModel
import com.android.example.podomarket.ui.main.MainViewModel
import com.android.example.podomarket.ui.main.chat.ChatRoomListViewModel
import com.android.example.podomarket.ui.main.mypage.MyPageViewModel
import com.android.example.podomarket.ui.main.product.ProductViewModel
import com.android.example.podomarket.ui.user.login.LoginViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { LoginViewModel(get()) }
    single { MainViewModel() }
    single { ProductViewModel(get()) }
    single { MyPageViewModel(get()) }
    single { ChatRoomViewModel(get(), get()) }
    single { ChatRoomListViewModel(get()) }
}
