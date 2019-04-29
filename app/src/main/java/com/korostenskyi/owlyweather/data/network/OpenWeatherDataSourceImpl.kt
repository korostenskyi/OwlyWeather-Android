package com.korostenskyi.owlyweather.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.korostenskyi.owlyweather.data.entity.OpenWeather.WeatherCurrentResponse
import com.korostenskyi.owlyweather.data.network.api.OpenWeatherApiService

class OpenWeatherDataSourceImpl(private val apiService: OpenWeatherApiService): OpenWeatherDataSource {

    private val _fetchedCurrentWeather = MutableLiveData<WeatherCurrentResponse>()

    override val fetchedCurrentWeather: LiveData<WeatherCurrentResponse>
        get() = _fetchedCurrentWeather

    override suspend fun fetchCurrentWeatherAsync(lat: Double, lon: Double) {
        val currentWeather = apiService.fetchCurrentWeatherAsync(lat, lon).await()

        _fetchedCurrentWeather.postValue(currentWeather)
    }
}