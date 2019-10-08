package com.korostenskyi.domain.repository

import com.korostenskyi.domain.model.CurrentWeather
import com.korostenskyi.domain.model.ForecastWeather

interface WeatherRepository {

    suspend fun fetchCurrentWeather(lat: Double, lon: Double): CurrentWeather

    suspend fun fetchForecastWeather(lat: Double, lon: Double): ForecastWeather
}