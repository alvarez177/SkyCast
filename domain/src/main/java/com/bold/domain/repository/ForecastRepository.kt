package com.bold.domain.repository

import com.bold.domain.model.ForecastInformation

interface ForecastRepository {

    suspend fun fetchForecast(location: String): ForecastInformation
}