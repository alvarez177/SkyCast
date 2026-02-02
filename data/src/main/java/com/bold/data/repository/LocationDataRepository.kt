package com.bold.data.repository

import com.bold.data.model.LocationApi
import com.bold.data.network.WeatherService
import com.bold.domain.model.Location
import com.bold.domain.repository.LocationRepository
import retrofit2.Response
import javax.inject.Inject

class LocationDataRepository @Inject constructor(private val service: WeatherService) :
    LocationRepository {

    private var locations: List<Location>? = null

    override suspend fun fetchLocations(location: String): List<Location> {
        val response: Response<List<LocationApi>> = service.fetchLocations(location)
        val locationsApi: List<LocationApi>? = response.body()
        return locationsApi?.let {
            locations = it.map { locationApi -> locationApi.toDomain() }
            locations
        } ?: throw Exception("Location response body not found")
    }
}