package com.korostenskyi.domain.model

data class CurrentWeather(
    val cityName: String,
    val numericalData: NumericalData,
    val weather: List<Weather>,
    val wind: Wind
)