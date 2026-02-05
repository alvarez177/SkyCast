package com.bold.skycast.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.bold.domain.exception.LocationError
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val fetchLocationsUseCase: FetchLocationsUseCase,
    private val fetchForecastUseCase: FetchForecastUseCase,
    private val weatherScreenVisualizeMapper: WeatherScreenVisualizeMapper
) : BaseViewModel<WeatherScreenState, WeatherScreenEvent, WeatherScreenEffect>(
    initialState = WeatherScreenState(),
    reducer = WeatherScreenReducer()
) {

    private val searchQueryFlow = MutableStateFlow("")


    override suspend fun initialDataLoad() {
        observeSearchQuery()
        fetchWeather()
    }

    suspend fun fetchWeather(location: String = "Medellin") {
        coroutineScope {
            launch {
                sendEvent(WeatherScreenEvent.UpdateScreenLoading(
                    isLoading = true
                ))
                val forecastInformation: ForecastInformation = fetchForecastUseCase.invoke(location)
                sendEvent(
                    event = WeatherScreenEvent.UpdateWeather(
                        weatherScreenVisualizeMapper.map(
                            forecastInformation
                        )
                    )
                )
            }
        }
    }

    fun onClearQuery() {
        sendEvent(WeatherScreenEvent.SearchLocation(""))
    }

    fun onSearchLocation(query: String) {
        sendEvent(WeatherScreenEvent.SearchLocation(query))
        searchQueryFlow.value = query
    }

    fun onLocationSelected(locationVisualize: LocationVisualize) {
        sendEvent(
            event = WeatherScreenEvent.SelectLocation(
                locationVisualize = locationVisualize
            )
        )
    }

    private fun observeSearchQuery() {
        viewModelScope.launch {
            searchQueryFlow
                .debounce(400)
                .distinctUntilChanged()
                .collectLatest { query ->

                    if (query.isBlank()) {
                        sendEvent(
                            WeatherScreenEvent.ShowLocationsResult(emptyList())
                        )
                        return@collectLatest
                    }

                    runCatching {
                        fetchLocationsUseCase.invoke(query)
                    }.onSuccess { locations ->
                        sendEvent(
                            WeatherScreenEvent.ShowLocationsResult(
                                locations.map {
                                    LocationVisualize(
                                        id = it.id,
                                        name = it.name,
                                        region = it.region,
                                        country = it.country
                                    )
                                }
                            )
                        )
                    }.onFailure { error ->
                        when (error) {
                            LocationError.EmptyResult ->
                                sendEvent(WeatherScreenEvent.ShowLocationsResult(emptyList()))

                            LocationError.NetworkError ->
                                sendEvent(WeatherScreenEvent.ErrorSearchLocation("Error de red"))

                            LocationError.InvalidResponse ->
                                sendEvent(WeatherScreenEvent.ErrorSearchLocation("Respuesta inválida"))

                            else ->
                                sendEvent(WeatherScreenEvent.ErrorSearchLocation("Error inesperado"))
                        }
                    }
                }
        }
    }
}