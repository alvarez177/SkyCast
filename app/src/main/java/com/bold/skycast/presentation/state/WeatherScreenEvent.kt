package com.bold.skycast.presentation.state

import com.bold.skycast.presentation.model.WeatherScreenInformationVisualize

sealed class WeatherScreenEvent : Reducer.ViewEvent {
    data class UpdateScreenLoading(val isLoading: Boolean): WeatherScreenEvent()
    data class UpdateWeather(val weatherScreenInformationVisualize: WeatherScreenInformationVisualize) : WeatherScreenEvent()
}