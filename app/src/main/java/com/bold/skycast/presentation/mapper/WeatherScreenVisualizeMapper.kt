package com.bold.skycast.presentation.mapper

import com.bold.domain.model.ForecastInformation
import com.bold.skycast.presentation.model.CurrentWeatherVisualize
import com.bold.skycast.presentation.model.DayVisualize
import com.bold.skycast.presentation.model.ForecastDayVisualize
import com.bold.skycast.presentation.model.ForecastVisualize
import com.bold.skycast.presentation.model.LocationVisualize
import com.bold.skycast.presentation.model.WeatherConditionVisualize
import com.bold.skycast.presentation.model.WeatherScreenInformationVisualize
import com.bold.skycast.presentation.model.WeatherType
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
            ),
            weatherType = mapToWeatherType(forecastInformation.currentWeather.condition.code)
        )
    }
    private fun mapToWeatherType(conditionCode: Int): WeatherType {
        return when (conditionCode) {
            1000                   -> WeatherType.SUNNY
            1003, 1006, 1009       -> WeatherType.CLOUDY

            1030, 1135, 1147       -> WeatherType.FOG

            1150, 1153             -> WeatherType.DRIZZLE
            1180, 1183, 1186, 1189,
            1240, 1243, 1246       -> WeatherType.RAINY

            1192, 1195             -> WeatherType.HEAVY_RAIN

            1066, 1210, 1213, 1216,
            1219, 1222, 1225       -> WeatherType.SNOW

            1069, 1204, 1207,
            1249, 1252             -> WeatherType.SLEET

            1273, 1276             -> WeatherType.THUNDER

            1261, 1264, 1255, 1258 -> WeatherType.SNOW_SHOWER

            1087                    -> WeatherType.THUNDER_OUTBREAK
            1114, 1117              -> WeatherType.BLIZZARD
            1171, 1168              -> WeatherType.FREEZING
            1237                    -> WeatherType.ICE_PELLETS

            else -> WeatherType.UNKNOWN
        }
    }
}
