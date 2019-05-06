package com.korostenskyi.owlyweather.data.entity

import com.google.gson.annotations.SerializedName

data class WeatherForecastResponse(
    @SerializedName("cod") var responseCode: String,
    @SerializedName("list") var forecastList: List<ForecastBody>,
    @SerializedName("city") var city: City
)