package com.android.example.podomarket

import android.app.Application
import com.android.example.podomarket.di.networkModule
import com.android.example.podomarket.di.repositoryModule
import com.android.example.podomarket.di.viewModelModule
import com.kakao.sdk.common.KakaoSdk
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class PodoMarketApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
        startKoin {
            androidContext(this@PodoMarketApplication)
            modules(networkModule, repositoryModule, viewModelModule)
        }
        KakaoSdk.init(this, getString(R.string.KAKAO_APP_KEY))
    }
}