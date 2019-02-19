package com.korostenskyi.owlyweather

import android.app.Application
import com.korostenskyi.owlyweather.di.appModule
import org.koin.android.ext.android.startKoin

class OwlyWeatherApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}