package com.korostenskyi.data.repository

import com.korostenskyi.data.network.OpenWeatherDataSource
import com.korostenskyi.data.utils.toCurrentWeather
import com.korostenskyi.data.utils.toForecastWeather
import com.korostenskyi.domain.model.CurrentWeather
import com.korostenskyi.domain.model.ForecastWeather
import com.korostenskyi.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WeatherRepositoryImpl(private val apiDataSource: OpenWeatherDataSource) : WeatherRepository {

    override suspend fun fetchCurrentWeather(lat: Double, lon: Double): Flow<CurrentWeather> {
        return apiDataSource.fetchCurrentWeather(lat, lon).map { it.toCurrentWeather() }
    }

    override suspend fun fetchForecastWeather(lat: Double, lon: Double): Flow<ForecastWeather> {
        return apiDataSource.fetchForecastWeather(lat, lon).map { it.toForecastWeather() }
    }
}