package com.bold.skycast.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bold.skycast.presentation.model.CurrentWeatherVisualize
import com.bold.skycast.presentation.model.DayVisualize
import com.bold.skycast.presentation.model.ForecastDayVisualize
import com.bold.skycast.presentation.model.ForecastVisualize
import com.bold.skycast.presentation.model.LocationVisualize
import com.bold.skycast.presentation.model.WeatherConditionVisualize
import com.bold.skycast.presentation.model.WeatherScreenInformationVisualize
import com.bold.skycast.presentation.state.WeatherScreenEffect
import com.bold.skycast.presentation.viewmodel.WeatherViewModel


@Composable
fun SkyCastContentScreenRoute(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsState()

    uiState.weatherScreenInformationVisualize?.let {
        SkyCastScreen(
            weatherScreenInformationVisualize = it,
            query = uiState.searchQuery.orEmpty(),
            isSearching = uiState.isSearching,
            locationResults = uiState.locationsResult,
            searchLocationsErrorMessage = uiState.searchLocationsError,
            onLocationSelected = viewModel::onLocationSelected,
            onQueryChange = viewModel::onSearchLocation
        )
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is WeatherScreenEffect.FetchWeatherInformation -> {
                    viewModel.fetchWeather(effect.location)
                }
            }
        }
    }
}

@Composable
fun SkyCastScreen(
    weatherScreenInformationVisualize: WeatherScreenInformationVisualize,
    query: String,
    isSearching: Boolean,
    locationResults: List<LocationVisualize>,
    searchLocationsErrorMessage: String?,
    onLocationSelected: (LocationVisualize) -> Unit,
    onQueryChange: (String) -> Unit
) {
    Scaffold { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(horizontal = 8.dp)) {
            LocationSearchBar(
                query = query,
                isSearching = isSearching,
                onQueryChange = onQueryChange,
                results = locationResults,
                searchLocationsErrorMessage = searchLocationsErrorMessage,
                onLocationSelected = onLocationSelected
            )
            CurrentWeatherStateSection(
                location = weatherScreenInformationVisualize.locationVisualize.name,
                currentWeatherVisualize = weatherScreenInformationVisualize.currentWeatherVisualize
            )
            Spacer(modifier = Modifier.height(10.dp))
            ForecastSection(weatherScreenInformationVisualize.forecastVisualize)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SkyCastScreenPreview() {
    val weatherScreenInformationVisualize = WeatherScreenInformationVisualize(
        locationVisualize = LocationVisualize(
            id = 0,
            name = "Medellin",
            region = "",
            country = "Colombia"
        ),
        currentWeatherVisualize = CurrentWeatherVisualize(
            temperature = 20f,
            condition = WeatherConditionVisualize(
                text = "Partly cloudy",
                icon = "",
                code = 0
            )
        ),
        forecastVisualize = ForecastVisualize(
            forecasts = listOf(
                ForecastDayVisualize(
                    date = "01/02",
                    dayName = "Lunes",
                    day = DayVisualize(
                        averageTemperature = 74f,
                        condition = WeatherConditionVisualize(
                            text = "Moderate rain",
                            icon = "icon",
                            code = 0
                        )
                    )
                )
            )
        )
    )
    SkyCastScreen(
        weatherScreenInformationVisualize = weatherScreenInformationVisualize,
        query = "",
        isSearching = false,
        locationResults = listOf(
            LocationVisualize(
                id = 0,
                name = "Medellin",
                region = "Antioquia",
                country = "Colombia"
            )
        ),
        searchLocationsErrorMessage = null,
        onLocationSelected = {},
        onQueryChange = {}
    )
}