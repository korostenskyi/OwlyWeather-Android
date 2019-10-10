package com.korostenskyi.data.service

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.Tasks
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.korostenskyi.domain.service.LocationService

class LocationServiceImpl(context: Context): LocationService {

    private val client: PlacesClient = Places.createClient(context)
    private var location: LatLng? = null

    override suspend fun fetchCurrentLocation(): Pair<Double, Double> {
        if (location == null) updateLocation()
        return Pair(location!!.latitude, location!!.longitude)
    }

    @SuppressLint("MissingPermission")
    private fun updateLocation() {
        listOf(Place.Field.LAT_LNG)
            .let { FindCurrentPlaceRequest.builder(it).build() }
            .let { client.findCurrentPlace(it) }
            .let { Tasks.await(it) }
            .also { location = it.placeLikelihoods[0].place.latLng }
    }
}