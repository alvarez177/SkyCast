package com.bold.skycast.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.bold.skycast.presentation.model.CurrentWeatherVisualize
import com.bold.skycast.presentation.model.WeatherConditionVisualize

@Composable
fun CurrentWeatherStateSection(location: String, currentWeatherVisualize: CurrentWeatherVisualize) {
    Card(
        modifier = Modifier.wrapContentWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = location,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF546E7A)
            )

            Text(
                text = "${currentWeatherVisualize.temperature}°",
                fontSize = 64.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF263238)
            )

            Text(
                text = currentWeatherVisualize.condition.text,
                fontSize = 16.sp,
                color = Color(0xFF78909C)
            )

            AsyncImage(
                modifier = Modifier.size(96.dp),
                model = "https:${currentWeatherVisualize.condition.icon}",
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurrentWeatherStateSectionPreview() {
    val location = "Medellin"
    val currentWeatherVisualize = CurrentWeatherVisualize(
        temperature = 20f,
        condition = WeatherConditionVisualize(
            text = "Partly cloudy",
            icon = "",
            code = 0
        )
    )
    CurrentWeatherStateSection(
        location = location,
        currentWeatherVisualize = currentWeatherVisualize
    )
}