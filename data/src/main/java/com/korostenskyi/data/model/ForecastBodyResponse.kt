package com.korostenskyi.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastBodyResponse(
    @Json(name = "dt") var date: Long,
    @Json(name = "main") var numericalData: NumericalDataResponse,
    @Json(name = "weather") var weather: List<WeatherResponse>,
    @Json(name = "wind") var wind: WindResponse,
    @Json(name = "dt_txt") var dateString: String
)