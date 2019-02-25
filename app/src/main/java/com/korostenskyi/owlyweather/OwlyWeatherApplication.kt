package com.korostenskyi.owlyweather

import android.app.Application
import com.korostenskyi.owlyweather.data.network.OpenWeatherDataSourceImpl
import com.korostenskyi.owlyweather.data.network.api.OpenWeatherApiService
import com.korostenskyi.owlyweather.data.repository.RepositoryImpl
import com.korostenskyi.owlyweather.di.appModule
import com.korostenskyi.owlyweather.ui.weather.current.CurrentWeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class OwlyWeatherApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(appModule)
    }
}