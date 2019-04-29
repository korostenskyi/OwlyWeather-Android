package com.korostenskyi.owlyweather.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.korostenskyi.owlyweather.data.entity.OpenWeather.WeatherCurrentResponse
import com.korostenskyi.owlyweather.data.entity.OpenWeather.WeatherForecastResponse
import com.korostenskyi.owlyweather.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    var currentWeather = MutableLiveData<WeatherCurrentResponse>()
    var forecastWeather = MutableLiveData<WeatherForecastResponse>()

    init {
        repository.currentWeather.observeForever { serverResponse ->
            currentWeather.value = serverResponse
        }

        repository.forecastWeather.observeForever { serverResponse ->
            forecastWeather.value = serverResponse
        }
    }

    suspend fun fetchCurrentWeather(lat: Double, lon: Double) {
        GlobalScope.launch(Dispatchers.IO) {
            repository.fetchCurrentWeather(lat, lon)
        }
    }

    suspend fun fetchForecastWeather(lat: Double, lon: Double) {
        GlobalScope.launch {
            repository.fetchForecastWeather(lat, lon)
        }
    }
}