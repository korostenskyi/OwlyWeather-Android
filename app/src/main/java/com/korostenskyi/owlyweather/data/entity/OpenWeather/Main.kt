package com.korostenskyi.owlyweather.data.entity.OpenWeather

data class Main(
    val temp: Double,
    val pressure: Double,
    val humidity: Double,
    val temp_min: Double,
    val temp_max: Double,
    val sea_level: Double,
    val grnd_level: Double
)