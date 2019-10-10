package com.korostenskyi.domain.interactor

import com.korostenskyi.domain.model.CurrentWeather
import com.korostenskyi.domain.model.ForecastWeather

interface WeatherInteractor {

    suspend fun fetchCurrentWeather(lat: Double, lon: Double): CurrentWeather

    suspend fun fetchForecastWeather(lat: Double, lon: Double): ForecastWeather
}