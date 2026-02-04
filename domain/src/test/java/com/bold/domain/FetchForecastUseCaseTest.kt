package com.bold.domain

import com.bold.domain.model.ForecastInformation
import com.bold.domain.repository.ForecastRepository
import com.bold.domain.usecase.FetchForecastUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class FetchForecastUseCaseTest {

    private val repository = mockk<ForecastRepository>()
    private lateinit var useCase: FetchForecastUseCase

    @Before
    fun setup() {
        useCase = FetchForecastUseCase(repository)
    }

    @Test
    fun `given location when invoke is called then should returns forecast information`()  {
        runTest {
            val location = "Medellin"
            val forecastInformation = mockk<ForecastInformation>()

            coEvery {
                repository.fetchForecast(location)
            } returns forecastInformation

            val result = useCase.invoke(location)

            coVerify(exactly = 1) {
                repository.fetchForecast(location)
            }

            Assert.assertEquals(forecastInformation, result)
        }
    }
}