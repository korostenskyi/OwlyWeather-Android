package com.korostenskyi.owlyweather.data.entity

import com.google.gson.annotations.SerializedName

data class ForecastBody(
    @SerializedName("dt") var date: Long,
    @SerializedName("main") var numericalData: NumericalData,
    @SerializedName("weather") var weather: List<Weather>,
    @SerializedName("wind") var wind: Wind,
    @SerializedName("dt_txt") var dateString: String
)