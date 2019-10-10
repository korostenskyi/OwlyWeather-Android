package com.korostenskyi.data.utils

import com.korostenskyi.data.model.*
import com.korostenskyi.domain.model.*

fun CityResponse.toCity() = City(
    name = name,
    country = country
)

fun ForecastBodyResponse.toForecast() = Forecast(
    date = date,
    numericalData = numericalData.toNumericalData(),
    weather = weather.map { it.toWeather() },
    wind = wind.toWind(),
    dateString = dateString
)

fun NumericalDataResponse.toNumericalData() = NumericalData(
    temperature = temperature,
    temperatureMin = temperatureMin,
    temperatureMax = temperatureMax,
    pressure = pressure,
    humidity = humidity
)

fun WeatherResponse.toWeather() = Weather(
    title = title,
    description = description,
    icon = icon
)

fun WindResponse.toWind() = Wind(
    speed = speed,
    degree = degree
)

fun WeatherCurrentResponse.toCurrentWeather() = CurrentWeather(
    cityName = cityName,
    numericalData = numericalData.toNumericalData(),
    weather = weather.map { it.toWeather() },
    wind = wind.toWind()
)

fun WeatherForecastResponse.toForecastWeather() = ForecastWeather(
    responseCode = responseCode,
    forecastList = forecastList.map { it.toForecast() },
    city = city.toCity()
)