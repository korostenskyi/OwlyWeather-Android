package com.korostenskyi.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindResponse(
    @Json(name = "speed") var speed: Double,
    @Json(name = "deg") var degree: Double
)