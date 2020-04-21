package com.korostenskyi.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherForecastResponse(
    @Json(name = "cod") var responseCode: String,
    @Json(name = "list") var forecastList: List<ForecastBodyResponse>,
    @Json(name = "city") var city: CityResponse
)