package com.bold.skycast.presentation.model

import com.bold.domain.model.Day

data class ForecastDayVisualize(
    val date: String,
    val dayApi: DayVisualize
)
