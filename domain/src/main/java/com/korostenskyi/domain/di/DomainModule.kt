package com.korostenskyi.domain.di

import com.korostenskyi.domain.interactor.WeatherInteractor
import com.korostenskyi.domain.interactor.WeatherInteractorImpl
import org.koin.dsl.module

val domainModule = module {

    single<WeatherInteractor> { WeatherInteractorImpl(get()) }
}