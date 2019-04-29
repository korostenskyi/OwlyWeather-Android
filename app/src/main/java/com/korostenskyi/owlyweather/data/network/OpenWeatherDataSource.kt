package com.korostenskyi.owlyweather.data.network

import androidx.lifecycle.LiveData
import com.korostenskyi.owlyweather.data.entity.OpenWeather.WeatherCurrentResponse

interface OpenWeatherDataSource {

    val fetchedCurrentWeather: LiveData<WeatherCurrentResponse>

    suspend fun fetchCurrentWeatherAsync(lat: Double, lon: Double)
}