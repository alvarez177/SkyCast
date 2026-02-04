package com.bold.skycast.presentation.state

sealed class WeatherScreenEffect : Reducer.ViewEffect {
    data class FetchWeatherInformation(val location: String) : WeatherScreenEffect()
}