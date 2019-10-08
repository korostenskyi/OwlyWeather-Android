package com.korostenskyi.data.repository

import com.korostenskyi.data.network.OpenWeatherDataSource
import com.korostenskyi.data.utils.toCurrentWeather
import com.korostenskyi.data.utils.toForecastWeather
import com.korostenskyi.domain.model.CurrentWeather
import com.korostenskyi.domain.model.ForecastWeather
import com.korostenskyi.domain.repository.WeatherRepository

class WeatherRepositoryImpl(private val apiDataSource: OpenWeatherDataSource): WeatherRepository {

    override suspend fun fetchCurrentWeather(lat: Double, lon: Double): CurrentWeather {
        return apiDataSource.fetchCurrentWeather(lat, lon).toCurrentWeather()
    }

    override suspend fun fetchForecastWeather(lat: Double, lon: Double): ForecastWeather {
        return apiDataSource.fetchForecastWeather(lat, lon).toForecastWeather()
    }
}