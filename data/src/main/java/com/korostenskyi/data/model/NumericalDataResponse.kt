package com.korostenskyi.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NumericalDataResponse(
    @Json(name = "temp") var temperature: Double,
    @Json(name = "temp_min") var temperatureMin: Double,
    @Json(name = "temp_max") var temperatureMax: Double,
    @Json(name = "pressure") var pressure: Double,
    @Json(name = "humidity") var humidity: Int
)