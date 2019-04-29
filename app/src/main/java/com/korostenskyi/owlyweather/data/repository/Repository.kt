package com.korostenskyi.owlyweather.data.repository

import androidx.lifecycle.MutableLiveData
import com.korostenskyi.owlyweather.data.entity.OpenWeather.WeatherCurrentResponse

interface Repository {

    val currentWeather: MutableLiveData<WeatherCurrentResponse>

    suspend fun fetchCurrentWeather(lat: Double, lon: Double)
}