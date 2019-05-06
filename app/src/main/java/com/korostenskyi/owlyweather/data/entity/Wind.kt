package com.korostenskyi.owlyweather.data.entity

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("speed") var speed: Double,
    @SerializedName("deg") var degree: Double
)