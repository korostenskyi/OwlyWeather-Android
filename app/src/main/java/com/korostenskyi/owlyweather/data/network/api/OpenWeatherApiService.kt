package com.korostenskyi.owlyweather.data.network.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.korostenskyi.owlyweather.data.entity.WeatherCurrentResponse
import com.korostenskyi.owlyweather.data.entity.WeatherForecastResponse
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

class OpenWeatherApiService {

    private val apiKey = "6beda136c0f88edfc5db7dd0efe3d955"

    private var client: OpenWeatherApiClient

    init {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()

        client = retrofit.create(OpenWeatherApiClient::class.java)
    }

    fun fetchCurrentWeatherAsync(lat: Double, lon: Double): Deferred<WeatherCurrentResponse> {
        return client.fetchCurrentWeatherAsync(lat, lon, apiKey)
    }

    fun fetchForecastWeatherAsync(lat: Double, lon: Double): Deferred<WeatherForecastResponse> {
        return client.fetchForecastWeatherAsync(lat, lon, apiKey)
    }
}