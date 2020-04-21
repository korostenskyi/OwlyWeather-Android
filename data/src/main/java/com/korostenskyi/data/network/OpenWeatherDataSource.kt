package com.korostenskyi.data.network

import com.korostenskyi.data.model.WeatherCurrentResponse
import com.korostenskyi.data.model.WeatherForecastResponse
import kotlinx.coroutines.flow.Flow

interface OpenWeatherDataSource {

    suspend fun fetchCurrentWeather(lat: Double, lon: Double): Flow<WeatherCurrentResponse>

    suspend fun fetchForecastWeather(lat: Double, lon: Double): Flow<WeatherForecastResponse>
}