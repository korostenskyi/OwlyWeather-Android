package com.korostenskyi.domain.repository

import com.korostenskyi.domain.model.CurrentWeather
import com.korostenskyi.domain.model.ForecastWeather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun fetchCurrentWeather(lat: Double, lon: Double): Flow<CurrentWeather>

    suspend fun fetchForecastWeather(lat: Double, lon: Double): Flow<ForecastWeather>
}