package com.korostenskyi.owlyweather.data.repository

import androidx.lifecycle.MutableLiveData
import com.korostenskyi.owlyweather.data.entity.WeatherCurrentResponse
import com.korostenskyi.owlyweather.data.entity.WeatherForecastResponse

interface Repository {

    val currentWeather: MutableLiveData<WeatherCurrentResponse>
    val forecastWeather:MutableLiveData<WeatherForecastResponse>

    suspend fun fetchCurrentWeather(lat: Double, lon: Double)
    suspend fun fetchForecastWeather(lat: Double, lon: Double)
}