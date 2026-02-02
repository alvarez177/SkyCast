package com.bold.data.model

import com.bold.domain.model.ForecastDay
import com.google.gson.annotations.SerializedName

data class ForecastDayApi(
    @SerializedName("date")
    val date: String,
    @SerializedName("day")
    val dayApi: DayApi
) {
    fun toDomain(): ForecastDay {
        return ForecastDay(
            date = date,
            day = dayApi.toDomain()
        )
    }
}
