package com.bold.data.model

import com.google.gson.annotations.SerializedName

data class ForecastApi(
    @SerializedName("forecastday")
    val forecasts: List<ForecastDayApi>
)
