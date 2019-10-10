package com.korostenskyi.data.model

import com.google.gson.annotations.SerializedName

data class ForecastBodyResponse(
    @SerializedName("dt") var date: Long,
    @SerializedName("main") var numericalData: NumericalDataResponse,
    @SerializedName("weather") var weather: List<WeatherResponse>,
    @SerializedName("wind") var wind: WindResponse,
    @SerializedName("dt_txt") var dateString: String
)