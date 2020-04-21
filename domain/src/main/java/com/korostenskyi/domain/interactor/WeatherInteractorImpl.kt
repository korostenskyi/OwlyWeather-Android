package com.korostenskyi.domain.interactor

import com.korostenskyi.domain.model.CurrentWeather
import com.korostenskyi.domain.model.ForecastWeather
import com.korostenskyi.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class WeatherInteractorImpl(private val weatherRepository: WeatherRepository) : WeatherInteractor {

    override suspend fun fetchCurrentWeather(lat: Double, lon: Double): Flow<CurrentWeather> {
        return weatherRepository.fetchCurrentWeather(lat, lon)
    }

    override suspend fun fetchForecastWeather(lat: Double, lon: Double): Flow<ForecastWeather> {
        return weatherRepository.fetchForecastWeather(lat, lon)
    }
}