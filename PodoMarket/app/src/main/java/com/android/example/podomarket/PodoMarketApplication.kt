package com.android.example.podomarket

import android.app.Application
import com.kakao.auth.IApplicationConfig
import com.kakao.auth.KakaoAdapter
import com.kakao.auth.KakaoSDK
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PodoMarketApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PodoMarketApplication)
        }
        KakaoSDK.init(
            object : KakaoAdapter() {
                override fun getApplicationConfig(): IApplicationConfig {
                    return IApplicationConfig { this@PodoMarketApplication }
                }
            }
        )
    }
}