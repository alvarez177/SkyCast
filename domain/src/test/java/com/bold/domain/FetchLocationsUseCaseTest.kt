package com.bold.domain

import com.bold.domain.exception.LocationError
import com.bold.domain.model.Location
import com.bold.domain.repository.LocationRepository
import com.bold.domain.usecase.FetchLocationsUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import kotlin.test.Test

class FetchLocationsUseCaseTest {

    private val repository = mockk<LocationRepository>()
    private lateinit var fetchLocationsUseCase: FetchLocationsUseCase

    @Before
    fun setup() {
        fetchLocationsUseCase = FetchLocationsUseCase(repository)
    }

    @Test
    fun `given locations when invoke is called then should return locations`() = runTest {
        val location = "Medellin"
        val locations = listOf(
            Location(
                id = 0,
                name = "Medellin",
                region = "Antioquia",
                country = "Colombia"
            )
        )

        coEvery {
            repository.fetchLocations(location)
        } returns locations

        val result = fetchLocationsUseCase.invoke(location)

        coVerify(exactly = 1) {
            repository.fetchLocations(location)
        }

        Assert.assertEquals(locations, result)
    }

    @Test
    fun `given no exist locations when invoke is called then should throw EmptyResult`() {
        val location = "Girardota"

        coEvery {
            repository.fetchLocations(location)
        } returns emptyList()

        Assert.assertThrows(LocationError.EmptyResult::class.java) {
            runBlocking {
                fetchLocationsUseCase.invoke(location)
            }
        }
    }

    @Test
    fun `given location when invoke is called and the repository fail then should throw network error`() {
        val query = "London"
        val error = LocationError.NetworkError

        coEvery {
            repository.fetchLocations(query)
        } throws error

        Assert.assertThrows(LocationError.NetworkError::class.java) {
            runBlocking {
                fetchLocationsUseCase.invoke(query)
            }
        }
    }
}
