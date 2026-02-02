package com.bold.data.model

import com.google.gson.annotations.SerializedName

data class ForecastDayApi(
    @SerializedName("date")
    val date: String,
    @SerializedName("day")
    val dayApi: DayApi
)
