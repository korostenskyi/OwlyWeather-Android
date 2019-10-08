package com.korostenskyi.domain.model

data class ForecastWeather(
    val responseCode: String,
    var forecastList: List<Forecast>,
    val city: City
)