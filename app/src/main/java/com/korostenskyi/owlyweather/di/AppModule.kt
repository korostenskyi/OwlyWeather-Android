package com.korostenskyi.owlyweather.di

import com.korostenskyi.owlyweather.BuildConfig
import com.korostenskyi.owlyweather.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single(named("OpenWeatherKey")) { BuildConfig.OW_API_KEY }
    single(named("OpenWeatherBaseUrl")) { BuildConfig.OW_BASE_URL }
    viewModel { MainViewModel(get()) }
}