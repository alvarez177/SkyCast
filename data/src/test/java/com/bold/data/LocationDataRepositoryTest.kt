package com.bold.data

import com.bold.data.model.LocationApi
import com.bold.data.network.WeatherService
import com.bold.data.repository.LocationDataRepository
import com.bold.domain.exception.LocationError
import com.bold.domain.model.Location
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

class LocationDataRepositoryTest {

    private val service = mockk<WeatherService>()
    private val location = "Medellin"

    private val repository = LocationDataRepository(service)

    @Test
    fun `given successful response when fetchLocations is called then return mapped locations`() {
        val inputLocation = "Medellin"

        val locationsApi = listOf(
            LocationApi(
                id = 0,
                name = inputLocation,
                region = "Antioquia",
                country = "Colombia"
            )
        )

        val expected = listOf(
            Location(
                id = 0,
                name = inputLocation,
                region = "Antioquia",
                country = "Colombia"
            )
        )

        val response = Response.success(locationsApi)

        coEvery { service.fetchLocations(inputLocation) } returns response

        val result = runBlocking {
            repository.fetchLocations(inputLocation)
        }
        coVerify(exactly = 1) { service.fetchLocations(inputLocation) }
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `given unsuccessful response when fetchLocations then throw NetworkError`() {
        val response = Response.error<List<LocationApi>>(
            500,
            mockk(relaxed = true)
        )

        coEvery { service.fetchLocations(location) } returns response

        Assert.assertThrows(LocationError.NetworkError::class.java) {
            runBlocking {
                repository.fetchLocations(location)
            }
        }
    }

    @Test
    fun `given successful response with null body when fetchLocations then throw InvalidResponse`() {
        val response = Response.success<List<LocationApi>>(null)

        coEvery { service.fetchLocations(location) } returns response

        Assert.assertThrows(LocationError.InvalidResponse::class.java) {
            runBlocking {
                repository.fetchLocations(location)
            }
        }
    }


}