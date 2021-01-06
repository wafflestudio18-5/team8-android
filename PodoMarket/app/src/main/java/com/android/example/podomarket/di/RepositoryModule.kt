package com.android.example.podomarket.di

import com.android.example.podomarket.data.repo.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        UserRepository(get(), get())
    }
}