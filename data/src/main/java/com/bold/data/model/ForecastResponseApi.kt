package com.bold.data.model

import com.bold.domain.model.ForecastInformation
import com.google.gson.annotations.SerializedName

data class ForecastResponseApi(
    @SerializedName("location")
    val locationApi: LocationApi,
    @SerializedName("current")
    val currentWeather: CurrentWeatherApi,
    @SerializedName("forecast")
    val forecast: ForecastApi
) {
    fun toDomain(): ForecastInformation {
        return ForecastInformation(
            location = locationApi.toDomain(),
            currentWeather = currentWeather.toDomain(),
            forecast = forecast.toDomain()
        )
    }
}
