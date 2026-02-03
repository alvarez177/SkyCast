package com.bold.skycast.presentation.mapper

import com.bold.domain.model.ForecastInformation
import com.bold.skycast.presentation.model.CurrentWeatherVisualize
import com.bold.skycast.presentation.model.DayVisualize
import com.bold.skycast.presentation.model.ForecastDayVisualize
import com.bold.skycast.presentation.model.ForecastVisualize
import com.bold.skycast.presentation.model.LocationVisualize
import com.bold.skycast.presentation.model.WeatherConditionVisualize
import com.bold.skycast.presentation.model.WeatherScreenInformationVisualize
import com.bold.skycast.presentation.util.DateFormatter
import javax.inject.Inject

class WeatherScreenVisualizeMapper @Inject constructor(
    private val dateFormatter: DateFormatter
) {

    fun map(forecastInformation: ForecastInformation): WeatherScreenInformationVisualize {
        return WeatherScreenInformationVisualize(
            locationVisualize = LocationVisualize(
                id = forecastInformation.location.id,
                name = forecastInformation.location.name,
                region = forecastInformation.location.region,
                country = forecastInformation.location.country
            ),
            currentWeatherVisualize = CurrentWeatherVisualize(
                temperature = forecastInformation.currentWeather.temperature,
                condition = WeatherConditionVisualize(
                    text = forecastInformation.currentWeather.condition.text,
                    icon = forecastInformation.currentWeather.condition.icon,
                    code = forecastInformation.currentWeather.condition.code
                )
            ),
            forecastVisualize = ForecastVisualize(
                forecasts = forecastInformation.forecast.forecasts.map { forecastDay ->
                    ForecastDayVisualize(
                        date = forecastDay.date,
                        dayName = dateFormatter.dayOfWeek(forecastDay.date),
                        day = DayVisualize(
                            averageTemperature = forecastDay.day.averageTemperature,
                            condition = WeatherConditionVisualize(
                                text = forecastDay.day.condition.text,
                                icon = forecastDay.day.condition.icon,
                                code = forecastDay.day.condition.code
                            )
                        )
                    )
                }
            )
        )
    }
}
