package com.korostenskyi.owlyweather.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.korostenskyi.domain.interactor.LocationInteractor
import com.korostenskyi.domain.interactor.WeatherInteractor
import com.korostenskyi.domain.model.CurrentWeather
import com.korostenskyi.domain.model.ForecastWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val weatherInteractor: WeatherInteractor,
    private val locationInteractor: LocationInteractor
): ViewModel() {

    var currentWeatherLiveData = MutableLiveData<CurrentWeather>()
    var forecastWeatherLiveData = MutableLiveData<ForecastWeather>()

    private suspend fun fetchCurrentWeather(lat: Double, lon: Double) {
        GlobalScope.launch(Dispatchers.IO) {
            currentWeatherLiveData.postValue(weatherInteractor.fetchCurrentWeather(lat, lon))
        }
    }

    private suspend fun fetchForecastWeather(lat: Double, lon: Double) {
        GlobalScope.launch {
            forecastWeatherLiveData.postValue(weatherInteractor.fetchForecastWeather(lat, lon))
        }
    }

    suspend fun fetchData() {
        val location = locationInteractor.fetchCurrentLocation()
        fetchCurrentWeather(location.first, location.second)
        fetchForecastWeather(location.first, location.second)
    }
}