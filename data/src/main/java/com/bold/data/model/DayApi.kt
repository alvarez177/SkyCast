package com.bold.data.model

import com.bold.domain.model.Day
import com.google.gson.annotations.SerializedName

data class DayApi(
    @SerializedName("avgtemp_f")
    val averageTemperature: Float,
    @SerializedName("condition")
    val condition: WeatherConditionApi
) {
    fun toDomain(): Day {
        return Day(
            averageTemperature = averageTemperature,
            condition = condition.toDomain()
        )
    }
}
