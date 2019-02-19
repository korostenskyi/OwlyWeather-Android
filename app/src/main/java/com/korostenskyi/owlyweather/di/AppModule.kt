package com.korostenskyi.owlyweather.di

import com.korostenskyi.owlyweather.data.repository.Repository
import com.korostenskyi.owlyweather.data.repository.RepositoryImpl
import com.korostenskyi.owlyweather.ui.weather.current.CurrentWeatherViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    // CurrentWeather repository
    single<Repository> { RepositoryImpl() }

    // CurrentWeather ViewModel
    viewModel {CurrentWeatherViewModel(get())}
}