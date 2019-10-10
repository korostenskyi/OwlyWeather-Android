package com.korostenskyi.domain.interactor

import com.korostenskyi.domain.service.LocationService

class LocationInteractorImpl(private val locationService: LocationService): LocationInteractor {

    override suspend fun fetchCurrentLocation() = locationService.fetchCurrentLocation()
}