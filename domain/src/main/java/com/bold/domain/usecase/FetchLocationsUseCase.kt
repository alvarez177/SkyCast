package com.bold.domain.usecase

import com.bold.domain.exception.LocationError
import com.bold.domain.model.Location
import com.bold.domain.repository.LocationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FetchLocationsUseCase @Inject constructor(private val repository: LocationRepository) {

    suspend operator fun invoke(inputValue: String): List<Location> {
        val locations = withContext(Dispatchers.IO) {
            repository.fetchLocations(inputValue)
        }
        if (locations.isEmpty()) {
            throw LocationError.EmptyResult
        } else {
            return locations
        }
    }
}