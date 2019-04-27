package com.korostenskyi.owlyweather.data.repository

import androidx.lifecycle.MutableLiveData
import com.korostenskyi.owlyweather.data.network.OpenWeatherDataSource
import com.korostenskyi.owlyweather.data.entity.OpenWeather.CurrentWeather

class RepositoryImpl(private val openWeatherDataSource: OpenWeatherDataSource): Repository {

    override val currentWeather = MutableLiveData<CurrentWeather>()

    init {
        openWeatherDataSource.fetchedCurrentWeather.observeForever { serverResponse ->
            currentWeather.value = serverResponse
        }
    }

    override suspend fun fetchCurrentWeather(lat: Double, lon: Double) {
        openWeatherDataSource.fetchCurrentWeatherAsync(lat, lon)
    }
}