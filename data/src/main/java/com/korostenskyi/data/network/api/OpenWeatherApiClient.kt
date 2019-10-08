package com.korostenskyi.data.network.api

import com.korostenskyi.data.model.WeatherCurrentResponse
import com.korostenskyi.data.model.WeatherForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApiClient {

    @GET("weather")
    suspend fun fetchCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String
    ): WeatherCurrentResponse

    @GET("forecast")
    suspend fun fetchForecastWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String
    ): WeatherForecastResponse
}