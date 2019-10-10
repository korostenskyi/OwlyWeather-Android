package com.korostenskyi.data.model

import com.google.gson.annotations.SerializedName

data class WeatherCurrentResponse(
    @SerializedName("name") var cityName: String,
    @SerializedName("main") var numericalData: NumericalDataResponse,
    @SerializedName("weather") var weather: List<WeatherResponse>,
    @SerializedName("wind") var wind: WindResponse
)