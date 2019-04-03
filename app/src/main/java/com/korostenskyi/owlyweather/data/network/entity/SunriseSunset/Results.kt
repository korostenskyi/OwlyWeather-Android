package com.korostenskyi.owlyweather.data.network.entity.SunriseSunset

data class Results(
    val sunrise: String,
    val sunset: String,
    val solar_noon: String,
    val day_length: String,
    val civil_twilight_begin: String,
    val civil_twilight_end: String,
    val nautical_twilight_begin: String,
    val nautical_twilight_end: String,
    val astronomical_twilight_begin: String,
    val astronomical_twilight_end: String
)