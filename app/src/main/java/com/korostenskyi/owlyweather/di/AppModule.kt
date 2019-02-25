package com.korostenskyi.owlyweather.di

import com.korostenskyi.owlyweather.data.network.OpenWeatherDataSourceImpl
import com.korostenskyi.owlyweather.data.network.api.OpenWeatherApiService
import com.korostenskyi.owlyweather.data.repository.RepositoryImpl
import com.korostenskyi.owlyweather.ui.weather.current.CurrentWeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val appModule = Kodein.Module("app") {

    // OpenWeatherApiService
    bind() from singleton { OpenWeatherApiService() }

    // OpenWeatherDataSourceImpl
    bind() from singleton { OpenWeatherDataSourceImpl(instance()) }

    // OpenWeatherRepositoryImpl
    bind() from singleton { RepositoryImpl(instance()) }

    // CurrentWeatherViewModelFactory
    bind() from provider { CurrentWeatherViewModelFactory(instance()) }
}