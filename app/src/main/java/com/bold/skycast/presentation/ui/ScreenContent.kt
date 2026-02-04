package com.bold.skycast.presentation.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bold.skycast.presentation.model.CurrentWeatherVisualize
import com.bold.skycast.presentation.model.DayVisualize
import com.bold.skycast.presentation.model.ForecastDayVisualize
import com.bold.skycast.presentation.model.ForecastVisualize
import com.bold.skycast.presentation.model.LocationVisualize
import com.bold.skycast.presentation.model.WeatherConditionVisualize
import com.bold.skycast.presentation.model.WeatherScreenInformationVisualize

@Composable
fun ScreenContent(
    weatherScreenInformationVisualize: WeatherScreenInformationVisualize
) {

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        LandscapeContent(weatherScreenInformationVisualize)
    } else {
        PortraitContent(weatherScreenInformationVisualize)
    }
}

@Composable
fun PortraitContent(
    weatherScreenInformationVisualize: WeatherScreenInformationVisualize
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        CurrentWeatherStateSection(
            location = weatherScreenInformationVisualize.locationVisualize.name,
            currentWeatherVisualize = weatherScreenInformationVisualize.currentWeatherVisualize
        )

        Spacer(modifier = Modifier.height(10.dp))

        ForecastSection(
            weatherScreenInformationVisualize.forecastVisualize
        )
    }
}

@Composable
fun LandscapeContent(
    weather: WeatherScreenInformationVisualize
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            CurrentWeatherStateSection(
                location = weather.locationVisualize.name,
                currentWeatherVisualize = weather.currentWeatherVisualize
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            ForecastSection(weather.forecastVisualize)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenContentPreview() {
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
    ScreenContent(
        weatherScreenInformationVisualize = weatherScreenInformationVisualize
    )
}
