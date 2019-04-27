package com.korostenskyi.owlyweather.data.repository

import androidx.lifecycle.MutableLiveData
import com.korostenskyi.owlyweather.data.entity.OpenWeather.CurrentWeather

interface Repository {

    val currentWeather: MutableLiveData<CurrentWeather>

    suspend fun fetchCurrentWeather(lat: Double, lon: Double)
}