package com.bold.data.repository

import com.bold.data.model.ForecastResponseApi
import com.bold.data.network.WeatherService
import com.bold.domain.model.ForecastInformation
import com.bold.domain.repository.ForecastRepository
import javax.inject.Inject

class ForecastDataRepository @Inject constructor(private val service: WeatherService) : ForecastRepository {

    override suspend fun fetchForecast(location: String): ForecastInformation {
        val response: ForecastResponseApi? = service.fetchForecast(location).body()
        return response?.toDomain() ?: throw Exception("Location response body not found")
    }
}