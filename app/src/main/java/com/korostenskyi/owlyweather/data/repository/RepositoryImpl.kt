package com.korostenskyi.owlyweather.data.repository

import androidx.lifecycle.MutableLiveData
import com.korostenskyi.owlyweather.data.entity.WeatherCurrentResponse
import com.korostenskyi.owlyweather.data.entity.WeatherForecastResponse
import com.korostenskyi.owlyweather.data.network.OpenWeatherDataSource

class RepositoryImpl(private val openWeatherDataSource: OpenWeatherDataSource): Repository {

    override val currentWeather = MutableLiveData<WeatherCurrentResponse>()
    override val forecastWeather = MutableLiveData<WeatherForecastResponse>()

    init {
        openWeatherDataSource.fetchedCurrentWeather.observeForever { serverResponse ->
            currentWeather.value = serverResponse
        }

        openWeatherDataSource.fetchedForecastWeather.observeForever { serverResponse ->
            forecastWeather.value = serverResponse
        }
    }

    override suspend fun fetchCurrentWeather(lat: Double, lon: Double) {
        openWeatherDataSource.fetchCurrentWeatherAsync(lat, lon)
    }

    override suspend fun fetchForecastWeather(lat: Double, lon: Double) {
        openWeatherDataSource.fetchForecastWeatherAsync(lat, lon)
    }
}