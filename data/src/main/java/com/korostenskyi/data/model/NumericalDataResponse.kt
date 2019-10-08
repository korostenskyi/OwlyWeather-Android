package com.korostenskyi.data.model

import com.google.gson.annotations.SerializedName

data class NumericalDataResponse(
    @SerializedName("temp") var temperature: Double,
    @SerializedName("temp_min") var temperatureMin: Double,
    @SerializedName("temp_max") var temperatureMax: Double,
    @SerializedName("pressure") var pressure: Double,
    @SerializedName("humidity") var humidity: Int
)