package com.bold.skycast.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.bold.skycast.presentation.model.CurrentWeatherVisualize
import com.bold.skycast.presentation.model.WeatherConditionVisualize

@Composable
fun CurrentWeatherStateSection(location: String, currentWeatherVisualize: CurrentWeatherVisualize) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = location,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = "${currentWeatherVisualize.temperature}°",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = currentWeatherVisualize.condition.text,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
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