package com.bold.skycast.presentation.state

import com.bold.skycast.presentation.model.LocationVisualize
import com.bold.skycast.presentation.model.WeatherScreenInformationVisualize

sealed class WeatherScreenEvent : Reducer.ViewEvent {
    data class UpdateScreenLoading(val isLoading: Boolean): WeatherScreenEvent()
    data class SearchLocation(val query: String) : WeatherScreenEvent()
    data class ShowLocationsResult(val locations: List<LocationVisualize>) : WeatherScreenEvent()
    data class SelectLocation(val locationVisualize: LocationVisualize) : WeatherScreenEvent()
    data class ErrorSearchLocation(val errorMessage: String) : WeatherScreenEvent()
    data class UpdateWeather(val weatherScreenInformationVisualize: WeatherScreenInformationVisualize) : WeatherScreenEvent()
}