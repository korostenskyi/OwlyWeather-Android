package com.korostenskyi.domain.model

data class Forecast(
    val date: Long,
    val numericalData: NumericalData,
    val weather: List<Weather>,
    val wind: Wind,
    val dateString: String
)