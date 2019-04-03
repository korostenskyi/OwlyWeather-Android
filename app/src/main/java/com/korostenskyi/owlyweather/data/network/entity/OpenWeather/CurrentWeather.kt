package com.korostenskyi.owlyweather.data.network.entity.OpenWeather

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("coord")
    val coordinates: Coordinates,
    @SerializedName("weather")
    val weatherArray: List<Weather>,
    val base: String,
    val main: Main,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val id: Int,
    val name: String,
    val cod: Int
)