package com.korostenskyi.owlyweather.di

import com.korostenskyi.owlyweather.data.repository.Repository
import com.korostenskyi.owlyweather.data.repository.RepositoryImpl
import com.korostenskyi.owlyweather.ui.weather.current.CurrentWeatherPresenter
import org.koin.dsl.module.module

val appModule = module {

    // Current weather repository
    single<Repository> { RepositoryImpl() }
}