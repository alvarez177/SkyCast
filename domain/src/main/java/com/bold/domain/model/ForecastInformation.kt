package com.bold.domain.model

data class ForecastInformation(
    val location: Location,
    val currentWeather: CurrentWeather,
    val forecast: Forecast
)
