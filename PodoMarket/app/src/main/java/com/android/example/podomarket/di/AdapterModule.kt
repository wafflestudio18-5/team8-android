package com.android.example.podomarket.di

import com.android.example.podomarket.ui.chat.ChatListAdapter
import org.koin.dsl.module

val adapterModule = module {
    factory { ChatListAdapter(get()) }
}