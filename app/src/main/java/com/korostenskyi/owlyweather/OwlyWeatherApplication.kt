package com.korostenskyi.owlyweather

import android.app.Application
import com.korostenskyi.data.di.dataModule
import com.korostenskyi.domain.di.domainModule
import com.korostenskyi.owlyweather.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class OwlyWeatherApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@OwlyWeatherApplication)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}