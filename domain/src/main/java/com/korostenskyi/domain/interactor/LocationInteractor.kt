package com.korostenskyi.domain.interactor

interface LocationInteractor {

    suspend fun fetchCurrentLocation(): Pair<Double, Double>
}