package com.korostenskyi.domain.model

data class NumericalData(
    val temperature: Double,
    val temperatureMin: Double,
    val temperatureMax: Double,
    val pressure: Double,
    val humidity: Int
)