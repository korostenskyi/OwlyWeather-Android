package com.korostenskyi.owlyweather.data.network

import androidx.lifecycle.LiveData
import com.korostenskyi.owlyweather.data.network.entity.OpenWeather.CurrentWeather

interface OpenWeatherDataSource {

    val fetchedCurrentWeather: LiveData<CurrentWeather>

    suspend fun fetchCurrentWeatherAsync(lat: Double, lon: Double)
}