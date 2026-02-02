package com.bold.data.model

import com.bold.domain.model.WeatherCondition
import com.google.gson.annotations.SerializedName

data class WeatherConditionApi(
    @SerializedName("text")
    val text: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("code")
    val code: Int
) {
    fun toDomain(): WeatherCondition {
        return WeatherCondition(
            text = text,
            icon = icon,
            code = code
        )
    }
}