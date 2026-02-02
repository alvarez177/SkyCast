package com.bold.domain.repository

import com.bold.domain.model.Location

interface LocationRepository {

    suspend fun fetchLocations(location: String): List<Location>
}