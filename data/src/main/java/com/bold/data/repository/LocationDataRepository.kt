package com.bold.data.repository

import com.bold.data.model.LocationApi
import com.bold.data.network.WeatherService
import com.bold.domain.exception.LocationError
import com.bold.domain.model.Location
import com.bold.domain.repository.LocationRepository
import retrofit2.Response
import javax.inject.Inject

class LocationDataRepository @Inject constructor(private val service: WeatherService) :
    LocationRepository {

    override suspend fun fetchLocations(location: String): List<Location> {
        val response: Response<List<LocationApi>> = service.fetchLocations(location)
        if (!response.isSuccessful) {
            throw LocationError.NetworkError
        }
        val locationsApi = response.body() ?: throw LocationError.InvalidResponse
        return locationsApi.map { it.toDomain() }
    }
}