package com.bold.skycast.presentation.viewmodel

import com.bold.skycast.presentation.state.WeatherScreenEffect
import com.bold.skycast.presentation.state.WeatherScreenEvent
import com.bold.skycast.presentation.state.WeatherScreenReducer
import com.bold.skycast.presentation.state.WeatherScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(): BaseViewModel<WeatherScreenState, WeatherScreenEvent, WeatherScreenEffect>(
    initialState = WeatherScreenState(),
    reducer = WeatherScreenReducer()
) {

    override suspend fun initialDataLoad() {
        super.initialDataLoad()
    }
}