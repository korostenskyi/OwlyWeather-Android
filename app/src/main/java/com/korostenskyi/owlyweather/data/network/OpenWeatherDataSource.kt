package com.korostenskyi.owlyweather.data.network

import androidx.lifecycle.LiveData
import com.korostenskyi.owlyweather.data.entity.WeatherCurrentResponse
import com.korostenskyi.owlyweather.data.entity.WeatherForecastResponse

interface OpenWeatherDataSource {

    val fetchedCurrentWeather: LiveData<WeatherCurrentResponse>
    val fetchedForecastWeather: LiveData<WeatherForecastResponse>

    suspend fun fetchCurrentWeatherAsync(lat: Double, lon: Double)
    suspend fun fetchForecastWeatherAsync(lat: Double, lon: Double)
}