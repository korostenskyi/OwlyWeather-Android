package com.korostenskyi.data.model

import com.google.gson.annotations.SerializedName

data class WindResponse(
    @SerializedName("speed") var speed: Double,
    @SerializedName("deg") var degree: Double
)