package com.korostenskyi.domain.interactor

import com.korostenskyi.domain.model.CurrentWeather
import com.korostenskyi.domain.model.ForecastWeather
import com.korostenskyi.domain.repository.WeatherRepository

class WeatherInteractorImpl(private val weatherRepository: WeatherRepository): WeatherInteractor {

    override suspend fun fetchCurrentWeather(lat: Double, lon: Double): CurrentWeather {
        return weatherRepository.fetchCurrentWeather(lat, lon)
    }

    override suspend fun fetchForecastWeather(lat: Double, lon: Double): ForecastWeather {
        return weatherRepository.fetchForecastWeather(lat, lon)
    }
}