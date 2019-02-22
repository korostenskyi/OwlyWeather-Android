package com.korostenskyi.owlyweather.data.network

import androidx.lifecycle.LiveData
import com.korostenskyi.owlyweather.data.network.entity.OpenWeather.CurrentWeather

class OpenWeatherDataSourceImpl : OpenWeatherDataSource {
    override val fetchedCurrentWeather: LiveData<CurrentWeather>
        get() =
                
}