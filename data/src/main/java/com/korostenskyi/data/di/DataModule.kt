package com.korostenskyi.data.di

import com.korostenskyi.data.network.OpenWeatherDataSource
import com.korostenskyi.data.network.OpenWeatherDataSourceImpl
import com.korostenskyi.data.network.api.OpenWeatherApiClientFactory
import com.korostenskyi.data.repository.WeatherRepositoryImpl
import com.korostenskyi.data.service.LocationServiceImpl
import com.korostenskyi.domain.repository.WeatherRepository
import com.korostenskyi.domain.service.LocationService
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single<LocationService> { LocationServiceImpl(androidContext()) }
    single { OpenWeatherApiClientFactory.createClient(get(named("OpenWeatherBaseUrl"))) }
    single<OpenWeatherDataSource> { OpenWeatherDataSourceImpl(get(), get(named("OpenWeatherKey"))) }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
}