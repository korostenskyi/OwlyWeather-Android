package com.korostenskyi.data.di

import com.korostenskyi.data.network.OpenWeatherDataSource
import com.korostenskyi.data.network.OpenWeatherDataSourceImpl
import com.korostenskyi.data.network.api.OpenWeatherApiClientFactory
import com.korostenskyi.data.repository.WeatherRepositoryImpl
import com.korostenskyi.domain.repository.WeatherRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {

    single { OpenWeatherApiClientFactory.createClient(get(named("OpenWeatherBaseUrl"))) }
    single<OpenWeatherDataSource> { OpenWeatherDataSourceImpl(get(), get(named("OpenWeatherKey"))) }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
}