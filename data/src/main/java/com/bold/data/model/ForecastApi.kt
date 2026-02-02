package com.bold.data.model

import com.bold.domain.model.Forecast
import com.google.gson.annotations.SerializedName

data class ForecastApi(
    @SerializedName("forecastday")
    val forecasts: List<ForecastDayApi>
) {
    fun toDomain(): Forecast {
        return Forecast(
            forecasts = forecasts.map {
                it.toDomain()
            }
        )
    }
}
