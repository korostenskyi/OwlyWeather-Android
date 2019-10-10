package com.korostenskyi.domain.service

interface LocationService {

    suspend fun fetchCurrentLocation(): Pair<Double, Double>
}