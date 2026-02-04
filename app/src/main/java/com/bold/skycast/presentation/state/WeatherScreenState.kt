package com.bold.skycast.presentation.state

import com.bold.skycast.presentation.model.LocationVisualize
import com.bold.skycast.presentation.model.WeatherScreenInformationVisualize

data class WeatherScreenState(
    val isLoading: Boolean = false,
    val searchBarContentLoading: Boolean = false,
    val searchQuery: String? = null,
    val isSearching: Boolean = false,
    val locationsResult: List<LocationVisualize> = emptyList(),
    val searchLocationsError: String? = null,
    val weatherScreenInformationVisualize: WeatherScreenInformationVisualize? = null
) : Reducer.ViewState
