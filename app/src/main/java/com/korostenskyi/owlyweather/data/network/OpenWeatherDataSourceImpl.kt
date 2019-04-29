package com.korostenskyi.owlyweather.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.korostenskyi.owlyweather.data.entity.OpenWeather.WeatherCurrentResponse
import com.korostenskyi.owlyweather.data.entity.OpenWeather.WeatherForecastResponse
import com.korostenskyi.owlyweather.data.network.api.OpenWeatherApiService

class OpenWeatherDataSourceImpl(private val apiService: OpenWeatherApiService): OpenWeatherDataSource {

    private val _fetchedCurrentWeather = MutableLiveData<WeatherCurrentResponse>()
    private val _fetchedForecastWeather = MutableLiveData<WeatherForecastResponse>()

    override val fetchedCurrentWeather: LiveData<WeatherCurrentResponse>
        get() = _fetchedCurrentWeather

    override val fetchedForecastWeather: LiveData<WeatherForecastResponse>
        get() = _fetchedForecastWeather

    override suspend fun fetchCurrentWeatherAsync(lat: Double, lon: Double) {
        val currentWeather = apiService.fetchCurrentWeatherAsync(lat, lon).await()

        _fetchedCurrentWeather.postValue(currentWeather)
    }

    override suspend fun fetchForecastWeatherAsync(lat: Double, lon: Double) {
        val forecastResponse = apiService.fetchForecastWeatherAsync(lat, lon).await()

        _fetchedForecastWeather.postValue(forecastResponse)
    }
}