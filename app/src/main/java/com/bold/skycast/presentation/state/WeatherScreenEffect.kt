package com.bold.skycast.presentation.state

sealed class WeatherScreenEffect : Reducer.ViewEffect {
    object Idle : WeatherScreenEffect()
}