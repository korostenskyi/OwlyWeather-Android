package com.korostenskyi.owlyweather.data.entity.OpenWeather

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("name") var name: String,
    @SerializedName("country") var country: String
)