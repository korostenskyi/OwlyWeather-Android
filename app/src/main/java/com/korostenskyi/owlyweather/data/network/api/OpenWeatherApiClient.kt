package com.korostenskyi.owlyweather.data.network.api

import com.korostenskyi.owlyweather.data.entity.WeatherCurrentResponse
import com.korostenskyi.owlyweather.data.entity.WeatherForecastResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApiClient {

    @GET(BASE_URL + "weather")
    fun fetchCurrentWeatherAsync(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String
    ): Deferred<WeatherCurrentResponse>

    @GET(BASE_URL + "forecast")
    fun fetchForecastWeatherAsync(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String
    ): Deferred<WeatherForecastResponse>
}