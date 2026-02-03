package com.bold.skycast.presentation.viewmodel

import com.bold.domain.model.ForecastInformation
import com.bold.domain.usecase.FetchForecastUseCase
import com.bold.domain.usecase.FetchLocationsUseCase
import com.bold.skycast.presentation.mapper.WeatherScreenVisualizeMapper
import com.bold.skycast.presentation.model.WeatherScreenInformationVisualize
import com.bold.skycast.presentation.state.WeatherScreenEffect
import com.bold.skycast.presentation.state.WeatherScreenEvent
import com.bold.skycast.presentation.state.WeatherScreenReducer
import com.bold.skycast.presentation.state.WeatherScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val fetchLocationsUseCase: FetchLocationsUseCase,
    private val fetchForecastUseCase: FetchForecastUseCase,
    private val weatherScreenVisualizeMapper: WeatherScreenVisualizeMapper
): BaseViewModel<WeatherScreenState, WeatherScreenEvent, WeatherScreenEffect>(
    initialState = WeatherScreenState(),
    reducer = WeatherScreenReducer()
) {

    override suspend fun initialDataLoad() {
        fetchWeather()
    }

    private suspend fun fetchWeather() {
        coroutineScope {
            launch {
                val forecastInformation: ForecastInformation = fetchForecastUseCase.invoke("Medellin")
                sendEvent(
                    event = WeatherScreenEvent.UpdateWeather(weatherScreenVisualizeMapper.map(forecastInformation))
                )
            }
        }
    }
}