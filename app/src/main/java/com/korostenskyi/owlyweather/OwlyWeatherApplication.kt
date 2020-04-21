package com.korostenskyi.owlyweather

import android.app.Application
import com.google.android.libraries.places.api.Places
import com.korostenskyi.data.di.dataModule
import com.korostenskyi.domain.di.domainModule
import com.korostenskyi.owlyweather.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class OwlyWeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initPlaces()
    }

    private fun initKoin() {
        val modules = listOf(
            appModule,
            domainModule,
            dataModule
        )
        startKoin {
            if (BuildConfig.DEBUG) printLogger(Level.DEBUG)
            androidContext(this@OwlyWeatherApplication)
            loadKoinModules(modules)
        }
    }

    private fun initPlaces() {
        Places.initialize(applicationContext, BuildConfig.PLACES_API_KEY)
    }
}