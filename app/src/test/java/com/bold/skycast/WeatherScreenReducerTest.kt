package com.bold.skycast

import com.bold.skycast.presentation.model.LocationVisualize
import com.bold.skycast.presentation.state.WeatherScreenEvent
import com.bold.skycast.presentation.state.WeatherScreenReducer
import com.bold.skycast.presentation.state.WeatherScreenState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class WeatherScreenReducerTest {

    private lateinit var reducer: WeatherScreenReducer

    @Before
    fun setup() {
        reducer = WeatherScreenReducer()
    }

    private fun defaultState() = WeatherScreenState(
        isLoading = false,
        searchBarContentLoading = false,
        searchQuery = "",
        isSearching = false,
        locationsResult = emptyList(),
        searchLocationsError = null,
        weatherScreenInformationVisualize = null
    )

    @Test
    fun `given SearchLocation event when reduce is called then should enable searching`() {
        val previousState = defaultState()
        val query = "Medellin"

        val (newState, effect) = reducer.reduce(
            previousState,
            WeatherScreenEvent.SearchLocation(query)
        )

        assertTrue(newState.searchBarContentLoading)
        assertTrue(newState.isSearching)
        assertEquals(query, newState.searchQuery)
        assertNull(effect)
    }

    @Test
    fun `given SearchLocation with blank query when reduce is called then searching is false`() {
        val previousState = defaultState()
        val query = ""

        val (newState, effect) = reducer.reduce(
            previousState,
            WeatherScreenEvent.SearchLocation(query)
        )

        assertTrue(newState.searchBarContentLoading)
        assertFalse(newState.isSearching)
        assertEquals(query, newState.searchQuery)
        assertNull(effect)
    }

    @Test
    fun `given ShowLocationsResult event when reduce is called then should show locations and clear error`() {
        val previousState = defaultState().copy(
            searchBarContentLoading = true,
            searchLocationsError = "Error previo"
        )

        val locations = listOf(
            LocationVisualize(
                id = 1,
                name = "Medellin",
                region = "Antioquia",
                country = "Colombia"
            )
        )

        val (newState, effect) = reducer.reduce(
            previousState,
            WeatherScreenEvent.ShowLocationsResult(locations)
        )

        assertFalse(newState.searchBarContentLoading)
        assertEquals(locations, newState.locationsResult)
        assertNull(newState.searchLocationsError)
        assertNull(effect)
    }


    @Test
    fun `given ErrorSearchLocation event when reduce is called then should show error and disable loading`() {
        val previousState = defaultState().copy(
            searchBarContentLoading = true
        )

        val errorMessage = "Network error"

        val (newState, effect) = reducer.reduce(
            previousState,
            WeatherScreenEvent.ErrorSearchLocation(errorMessage)
        )

        assertFalse(newState.searchBarContentLoading)
        assertEquals(errorMessage, newState.searchLocationsError)
        assertNull(effect)
    }
}
