package com.bold.data.model

import com.bold.domain.model.CurrentWeather
import com.google.gson.annotations.SerializedName

data class CurrentWeatherApi(
    @SerializedName("temp_c")
    val temperature: Float,
    @SerializedName("condition")
    val condition: WeatherConditionApi
) {
    fun toDomain(): CurrentWeather {
        return CurrentWeather(
            temperature = temperature,
            condition = condition.toDomain()
        )
    }
}