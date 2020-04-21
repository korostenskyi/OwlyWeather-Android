package com.korostenskyi.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    @Json(name = "main") val title: String,
    @Json(name = "description") val description: String,
    @Json(name = "icon") val icon: String
)