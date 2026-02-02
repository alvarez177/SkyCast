package com.bold.skycast.presentation.state

import com.bold.skycast.presentation.model.WeatherScreenInformationVisualize

data class WeatherScreenState(
    val isLoading: Boolean = false,
    val searchContent: String? = null,
    val weatherScreenInformationVisualize: WeatherScreenInformationVisualize? = null
) : Reducer.ViewState
