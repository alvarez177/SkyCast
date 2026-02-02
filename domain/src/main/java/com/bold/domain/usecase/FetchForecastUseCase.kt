package com.bold.domain.usecase

import com.bold.domain.model.ForecastInformation
import com.bold.domain.repository.ForecastRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FetchForecastUseCase @Inject constructor(private val repository: ForecastRepository) {

    suspend operator fun invoke(location: String): ForecastInformation {
        return withContext(Dispatchers.IO) {
            repository.fetchForecast(location)
        }
    }
}