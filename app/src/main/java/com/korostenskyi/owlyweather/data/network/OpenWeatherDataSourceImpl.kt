package com.korostenskyi.owlyweather.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.korostenskyi.owlyweather.data.network.api.OpenWeatherApiService
import com.korostenskyi.owlyweather.data.entity.OpenWeather.CurrentWeather

class OpenWeatherDataSourceImpl(private val apiService: OpenWeatherApiService): OpenWeatherDataSource {

    private val _fetchedCurrentWeather = MutableLiveData<CurrentWeather>()

    override val fetchedCurrentWeather: LiveData<CurrentWeather>
        get() = _fetchedCurrentWeather

    override suspend fun fetchCurrentWeatherAsync(lat: Double, lon: Double) {
        val currentWeather = apiService.fetchCurrentWeatherAsync(lat, lon).await()

        _fetchedCurrentWeather.postValue(currentWeather)
    }
}