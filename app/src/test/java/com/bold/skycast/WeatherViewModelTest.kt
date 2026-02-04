package com.bold.skycast

import com.bold.domain.model.Location
import com.bold.domain.usecase.FetchForecastUseCase
import com.bold.domain.usecase.FetchLocationsUseCase
import com.bold.skycast.presentation.mapper.WeatherScreenVisualizeMapper
import com.bold.skycast.presentation.state.WeatherScreenState
import com.bold.skycast.presentation.viewmodel.WeatherViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WeatherViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val fetchLocationsUseCase = mockk<FetchLocationsUseCase>()
    private val fetchForecastUseCase = mockk<FetchForecastUseCase>()
    private val weatherScreenVisualizeMapper = mockk<WeatherScreenVisualizeMapper>()

    private lateinit var viewModel: WeatherViewModel

    @Before
    fun setup() {
        viewModel = WeatherViewModel(
            fetchLocationsUseCase,
            fetchForecastUseCase,
            weatherScreenVisualizeMapper
        )
    }

    @Test
    fun `given query when onSearchLocation is called then should update state with locations`() =
        runTest {
            val location = "Medellin"
            val locations = listOf(
                Location(
                    0,
                    "Medellin",
                    "Antioquia",
                    "Colombia"
                )
            )

            coEvery {
                fetchLocationsUseCase.invoke(location)
            } answers {
                locations
            }

            val states = mutableListOf<WeatherScreenState>()

            val job = launch {
                viewModel.state.collect {
                    states.add(it)
                }
            }

            viewModel.onSearchLocation(location)

            advanceUntilIdle()

            val finalState = states.last()

            Assert.assertEquals(1, finalState.locationsResult.size)

            job.cancel()
        }
}