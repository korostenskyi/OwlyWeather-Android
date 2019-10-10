package com.korostenskyi.domain.di

import com.korostenskyi.domain.interactor.LocationInteractor
import com.korostenskyi.domain.interactor.LocationInteractorImpl
import com.korostenskyi.domain.interactor.WeatherInteractor
import com.korostenskyi.domain.interactor.WeatherInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    single<LocationInteractor> { LocationInteractorImpl(get()) }
    single<WeatherInteractor> { WeatherInteractorImpl(get()) }
}