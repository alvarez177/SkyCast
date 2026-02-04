package com.bold.data

import com.bold.data.model.ForecastResponseApi
import com.bold.data.network.WeatherService
import com.bold.data.repository.ForecastDataRepository
import com.bold.domain.model.ForecastInformation
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class ForecastDataRepositoryTest {
    private val service = mockk<WeatherService>()
    private lateinit var repository: ForecastDataRepository

    private val location = "Medellin"

    @Before
    fun setup() {
        repository = ForecastDataRepository(service)
    }

    @Test
    fun `given successful response when fetchForecast then return forecast information`()  {
        val forecastApi = mockk<ForecastResponseApi>()

        val expectedDomain = mockk<ForecastInformation>()

        every { forecastApi.toDomain() } returns expectedDomain

        coEvery {
            service.fetchForecast(location)
        } returns Response.success(forecastApi)

        val result = runBlocking {
            repository.fetchForecast(location)
        }

        coVerify(exactly = 1) {
            service.fetchForecast(location)
        }

        Assert.assertEquals(expectedDomain, result)
    }

    @Test
    fun `given null body when fetchForecast then throw exception`() {
        coEvery {
            service.fetchForecast(location)
        } returns Response.success(null)

        val exception = Assert.assertThrows(Exception::class.java) {
            runBlocking {
                repository.fetchForecast(location)
            }
        }

        Assert.assertEquals(
            "Location response body not found",
            exception.message
        )

        coVerify(exactly = 1) {
            service.fetchForecast(location)
        }
    }

}