package com.bold.skycast.presentation.model

data class WeatherScreenInformationVisualize(
    val locationVisualize: LocationVisualize,
    val currentWeatherVisualize: CurrentWeatherVisualize,
    val forecastVisualize: ForecastVisualize,
    val weatherType: WeatherType
) {
    fun getLocationName(): String {
        return locationVisualize.name
    }

    fun getTemperature(): String {
        return currentWeatherVisualize.temperature.toString()
    }
}
