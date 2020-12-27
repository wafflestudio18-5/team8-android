package com.android.example.podomarket

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PodoMarketApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PodoMarketApplication)
        }
        KakaoSdk.init(this, getString(R.string.KAKAO_APP_KEY))
    }
}