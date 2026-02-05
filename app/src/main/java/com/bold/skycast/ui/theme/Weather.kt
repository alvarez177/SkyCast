package com.bold.skycast.ui.theme

import androidx.compose.ui.graphics.Color
import com.bold.skycast.presentation.model.WeatherType

fun weatherBackground(type: WeatherType): List<Color> {
    return when (type) {

        WeatherType.SUNNY ->
            listOf(
                Color(0xFFFFF8E1),
                Color(0xFFFFECB3)
            )

        WeatherType.CLOUDY ->
            listOf(
                Color(0xFFCFD8DC),
                Color(0xFF90A4AE)
            )

        WeatherType.FOG ->
            listOf(
                Color(0xFFB0BEC5),
                Color(0xFFECEFF1)
            )

        WeatherType.DRIZZLE ->
            listOf(
                Color(0xFF81D4FA),
                Color(0xFF4FC3F7)
            )

        WeatherType.RAINY ->
            listOf(
                Color(0xFF4FC3F7),
                Color(0xFF0288D1)
            )

        WeatherType.HEAVY_RAIN ->
            listOf(
                Color(0xFF1565C0),
                Color(0xFF0D47A1)
            )

        WeatherType.THUNDER ->
            listOf(
                Color(0xFF455A64),
                Color(0xFF1C313A)
            )

        WeatherType.THUNDER_OUTBREAK ->
            listOf(
                Color(0xFF263238),
                Color(0xFF000000)
            )

        WeatherType.SNOW ->
            listOf(
                Color(0xFFE3F2FD),
                Color.White
            )

        WeatherType.SNOW_SHOWER ->
            listOf(
                Color(0xFFBBDEFB),
                Color(0xFFE3F2FD)
            )

        WeatherType.SLEET ->
            listOf(
                Color(0xFFB3E5FC),
                Color(0xFFCFD8DC)
            )

        WeatherType.BLIZZARD ->
            listOf(
                Color(0xFF90A4AE),
                Color(0xFF546E7A)
            )

        WeatherType.FREEZING ->
            listOf(
                Color(0xFFB2EBF2),
                Color(0xFFE0F7FA)
            )

        WeatherType.ICE_PELLETS ->
            listOf(
                Color(0xFF80DEEA),
                Color(0xFFB2EBF2)
            )

        WeatherType.UNKNOWN ->
            listOf(
                Color.LightGray,
                Color.Gray
            )
    }
}