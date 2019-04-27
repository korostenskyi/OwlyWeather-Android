package com.korostenskyi.owlyweather.data.entity.OpenWeather

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("cod") val cod: Int,
    @SerializedName("coord") val coordinates: Coordinates,
    @SerializedName("weather") val weatherArray: List<Weather>,
    @SerializedName("main") val main: Main,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("dt") val dt: Long,
    @SerializedName("name") val name: String
)