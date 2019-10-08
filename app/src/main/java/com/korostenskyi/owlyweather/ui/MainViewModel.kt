package com.korostenskyi.owlyweather.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.korostenskyi.domain.interactor.WeatherInteractor
import com.korostenskyi.domain.model.CurrentWeather
import com.korostenskyi.domain.model.ForecastWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val weatherInteractor: WeatherInteractor): ViewModel() {

    var currentWeatherLiveData = MutableLiveData<CurrentWeather>()
    var forecastWeatherLiveData = MutableLiveData<ForecastWeather>()

    fun fetchCurrentWeather(lat: Double, lon: Double) {
        GlobalScope.launch(Dispatchers.IO) {
            currentWeatherLiveData.postValue(weatherInteractor.fetchCurrentWeather(lat, lon))
        }
    }

    suspend fun fetchForecastWeather(lat: Double, lon: Double) {
        GlobalScope.launch {
            forecastWeatherLiveData.postValue(weatherInteractor.fetchForecastWeather(lat, lon))
        }
    }
}