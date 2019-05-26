package com.korostenskyi.owlyweather.di

import com.korostenskyi.owlyweather.data.network.OpenWeatherDataSource
import com.korostenskyi.owlyweather.data.network.OpenWeatherDataSourceImpl
import com.korostenskyi.owlyweather.data.network.api.OpenWeatherApiService
import com.korostenskyi.owlyweather.data.repository.Repository
import com.korostenskyi.owlyweather.data.repository.RepositoryImpl
import com.korostenskyi.owlyweather.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // OpenWeatherApiService
    single { OpenWeatherApiService() }

    // OpenWeatherDataSourceImpl
    single<OpenWeatherDataSource> { OpenWeatherDataSourceImpl(get()) }

    // OpenWeatherRepositoryImpl
    single<Repository> { RepositoryImpl(get()) }

    // MainViewModel
    viewModel { MainViewModel(get()) }
}