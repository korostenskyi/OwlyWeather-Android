package com.korostenskyi.domain.interactor

import com.korostenskyi.domain.model.CurrentWeather
import com.korostenskyi.domain.model.ForecastWeather
import kotlinx.coroutines.flow.Flow

interface WeatherInteractor {

    suspend fun fetchCurrentWeather(lat: Double, lon: Double): Flow<CurrentWeather>

    suspend fun fetchForecastWeather(lat: Double, lon: Double): Flow<ForecastWeather>
}