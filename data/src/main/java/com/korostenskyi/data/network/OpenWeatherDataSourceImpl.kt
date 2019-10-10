package com.korostenskyi.data.network

import com.korostenskyi.data.network.api.OpenWeatherApiClient

class OpenWeatherDataSourceImpl(
    private val client: OpenWeatherApiClient,
    private val appId: String
): OpenWeatherDataSource {

    override suspend fun fetchCurrentWeather(lat: Double, lon: Double) = client.fetchCurrentWeather(lat, lon, appId)

    override suspend fun fetchForecastWeather(lat: Double, lon: Double) = client.fetchForecastWeather(lat, lon, appId)
}