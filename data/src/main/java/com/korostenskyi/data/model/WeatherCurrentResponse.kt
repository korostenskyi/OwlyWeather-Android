package com.korostenskyi.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherCurrentResponse(
    @Json(name = "name") var cityName: String,
    @Json(name = "main") var numericalData: NumericalDataResponse,
    @Json(name = "weather") var weather: List<WeatherResponse>,
    @Json(name = "wind") var wind: WindResponse
)