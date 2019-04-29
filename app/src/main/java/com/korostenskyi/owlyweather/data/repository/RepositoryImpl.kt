package com.korostenskyi.owlyweather.data.repository

import androidx.lifecycle.MutableLiveData
import com.korostenskyi.owlyweather.data.entity.OpenWeather.WeatherCurrentResponse
import com.korostenskyi.owlyweather.data.network.OpenWeatherDataSource

class RepositoryImpl(private val openWeatherDataSource: OpenWeatherDataSource): Repository {

    override val currentWeather = MutableLiveData<WeatherCurrentResponse>()

    init {
        openWeatherDataSource.fetchedCurrentWeather.observeForever { serverResponse ->
            currentWeather.value = serverResponse
        }
    }

    override suspend fun fetchCurrentWeather(lat: Double, lon: Double) {
        openWeatherDataSource.fetchCurrentWeatherAsync(lat, lon)
    }
}