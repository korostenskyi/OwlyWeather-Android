package com.korostenskyi.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityResponse(
    @Json(name = "name") var name: String,
    @Json(name = "country") var country: String
)