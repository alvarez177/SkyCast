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
                    weatherScreenInformationVisualize = event.weatherScreenInformationVisualize
                ) to null
            }
        }
    }
}