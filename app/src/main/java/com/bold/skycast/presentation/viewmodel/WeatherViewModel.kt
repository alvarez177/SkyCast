package com.bold.skycast.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.bold.domain.model.ForecastInformation
import com.bold.domain.usecase.FetchForecastUseCase
import com.bold.domain.usecase.FetchLocationsUseCase
import com.bold.skycast.presentation.mapper.WeatherScreenVisualizeMapper
import com.bold.skycast.presentation.model.LocationVisualize
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

    suspend fun fetchWeather(location: String = "Medellin") {
        coroutineScope {
            launch {
                val forecastInformation: ForecastInformation = fetchForecastUseCase.invoke(location)
                sendEvent(
                    event = WeatherScreenEvent.UpdateWeather(weatherScreenVisualizeMapper.map(forecastInformation))
                )
            }
        }
    }

    fun onSearchLocation(query: String) {
        sendEvent(WeatherScreenEvent.SearchLocation(query))

        if (query.isBlank()) {
            sendEvent(
                WeatherScreenEvent.ShowLocationsResult(
                    locations = emptyList()
                )
            )
            return
        }
        viewModelScope.launch {
            runCatching {
                val locations = fetchLocationsUseCase.invoke(query)
                sendEvent(
                    event = WeatherScreenEvent.ShowLocationsResult(
                        locations = locations.map { location ->
                            LocationVisualize(
                                id = location.id,
                                name = location.name,
                                region = location.region,
                                country = location.country
                            )
                        }
                    )
                )

                /* val forecastInformation = fetchForecastUseCase.invoke(query)
                sendEvent(
                    WeatherScreenEvent.UpdateWeather(
                        weatherScreenVisualizeMapper.map(forecastInformation)
                    )
                )*/
            }.onFailure {
                sendEvent(
                    event = WeatherScreenEvent.ErrorSearchLocation("No se encontro la ubicación especificada")
                )
            }
        }
    }

    fun onLocationSelected(locationVisualize: LocationVisualize) {
        sendEvent(
            event = WeatherScreenEvent.SelectLocation(
                locationVisualize = locationVisualize
            )
        )
    }
}