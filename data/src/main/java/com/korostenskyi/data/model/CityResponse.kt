package com.korostenskyi.data.model

import com.google.gson.annotations.SerializedName

data class CityResponse(
    @SerializedName("name") var name: String,
    @SerializedName("country") var country: String
)