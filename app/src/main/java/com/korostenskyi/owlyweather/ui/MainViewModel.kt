package com.korostenskyi.owlyweather.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.korostenskyi.owlyweather.data.entity.OpenWeather.WeatherCurrentResponse
import com.korostenskyi.owlyweather.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    var currentWeather = MutableLiveData<WeatherCurrentResponse>()

    init {
        repository.currentWeather.observeForever { serverResponse ->
            currentWeather.value = serverResponse
        }
    }

    suspend fun fetchCurrentWeather(lat: Double, lon: Double) {
        GlobalScope.launch(Dispatchers.IO) {
            repository.fetchCurrentWeather(lat, lon)
        }
    }
}