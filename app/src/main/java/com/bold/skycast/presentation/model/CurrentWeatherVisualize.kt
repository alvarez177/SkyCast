package com.bold.skycast.presentation.model

import com.bold.domain.model.WeatherCondition

data class CurrentWeatherVisualize(
    val temperature: Float,
    val condition: WeatherConditionVisualize
)
