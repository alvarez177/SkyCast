package com.bold.skycast.presentation.state

class WeatherScreenReducer : Reducer<WeatherScreenState, WeatherScreenEvent, WeatherScreenEffect> {

    override fun reduce(
        previousState: WeatherScreenState,
        event: WeatherScreenEvent
    ): Pair<WeatherScreenState, WeatherScreenEffect?> {
        return when(event) {
            is WeatherScreenEvent.UpdateScreenLoading -> {
                previousState.copy(
                    isLoading = true
                ) to null
            }
            is WeatherScreenEvent.UpdateWeather -> {
                previousState.copy(
                    isLoading = false,
                    weatherScreenInformationVisualize = event.weatherScreenInformationVisualize
                ) to null
            }

            is WeatherScreenEvent.SearchLocation -> {
                previousState.copy(
                    searchBarContentLoading = true,
                    searchQuery = event.query,
                    isSearching = event.query.isNotBlank()
                ) to null
            }

            is WeatherScreenEvent.ShowLocationsResult -> {
                previousState.copy(
                    searchBarContentLoading = false,
                    locationsResult = event.locations,
                    searchLocationsError = null
                ) to null
            }

            is WeatherScreenEvent.SelectLocation -> {
                previousState.copy(
                    searchQuery = event.locationVisualize.name,
                    isSearching = false,
                    locationsResult = emptyList(),
                    searchBarContentLoading = false,
                    weatherScreenInformationVisualize = previousState.weatherScreenInformationVisualize?.copy(
                        locationVisualize = event.locationVisualize
                    )
                ) to WeatherScreenEffect.FetchWeatherInformation(event.locationVisualize.name)
            }

            is WeatherScreenEvent.ErrorSearchLocation -> {
                previousState.copy(
                    searchBarContentLoading = false,
                    searchLocationsError = event.errorMessage
                ) to null
            }
        }
    }
}