package com.korostenskyi.owlyweather

import android.app.Application
import com.google.android.libraries.places.api.Places
import com.korostenskyi.data.di.dataModule
import com.korostenskyi.domain.di.domainModule
import com.korostenskyi.owlyweather.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class OwlyWeatherApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Places.initialize(applicationContext, BuildConfig.PLACES_API_KEY)

        startKoin {
            androidContext(this@OwlyWeatherApplication)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}