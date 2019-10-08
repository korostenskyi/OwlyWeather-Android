package com.korostenskyi.data.model

import com.google.gson.annotations.SerializedName

data class WeatherForecastResponse(
    @SerializedName("cod") var responseCode: String,
    @SerializedName("list") var forecastList: List<ForecastBodyResponse>,
    @SerializedName("city") var city: CityResponse
)