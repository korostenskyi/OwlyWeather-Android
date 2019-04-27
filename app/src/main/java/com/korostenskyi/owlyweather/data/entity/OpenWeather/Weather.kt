package com.korostenskyi.owlyweather.data.entity.OpenWeather

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)