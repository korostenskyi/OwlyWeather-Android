package com.korostenskyi.owlyweather.data.entity

import com.google.gson.annotations.SerializedName

data class WeatherCurrentResponse(
    @SerializedName("name") var cityName: String,
    @SerializedName("main") var numericalData: NumericalData,
    @SerializedName("weather") var weather: List<Weather>,
    @SerializedName("wind") var wind: Wind
)