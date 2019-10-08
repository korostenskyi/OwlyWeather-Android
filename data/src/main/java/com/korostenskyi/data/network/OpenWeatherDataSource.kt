package com.korostenskyi.data.network

import com.korostenskyi.data.model.WeatherCurrentResponse
import com.korostenskyi.data.model.WeatherForecastResponse

interface OpenWeatherDataSource {

    suspend fun fetchCurrentWeather(lat: Double, lon: Double): WeatherCurrentResponse

    suspend fun fetchForecastWeather(lat: Double, lon: Double): WeatherForecastResponse
}