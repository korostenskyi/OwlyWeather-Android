package com.korostenskyi.owlyweather.data.entity

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("main") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)