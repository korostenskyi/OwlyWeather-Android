package com.korostenskyi.owlyweather.ui

import androidx.lifecycle.ViewModel
import com.korostenskyi.domain.interactor.LocationInteractor
import com.korostenskyi.domain.interactor.WeatherInteractor
import com.korostenskyi.domain.model.CurrentWeather
import com.korostenskyi.domain.model.ForecastWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class MainViewModel(
    private val weatherInteractor: WeatherInteractor,
    private val locationInteractor: LocationInteractor
): ViewModel() {

    suspend fun fetchCurrentWeather(): Flow<CurrentWeather> {
        val (lat, lon) = withContext(Dispatchers.IO) { locationInteractor.fetchCurrentLocation() }
        return weatherInteractor.fetchCurrentWeather(lat, lon)
    }

    suspend fun fetchForecastWeather(): Flow<ForecastWeather> {
        val (lat, lon) = withContext(Dispatchers.IO) { locationInteractor.fetchCurrentLocation() }
        return weatherInteractor.fetchForecastWeather(lat, lon)
    }
}