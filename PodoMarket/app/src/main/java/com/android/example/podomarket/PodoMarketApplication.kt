package com.android.example.podomarket

import android.app.Application
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
        }
        KakaoSdk.init(this, getString(R.string.KAKAO_APP_KEY))
    }
}