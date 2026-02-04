package com.bold.skycast.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.bold.skycast.R
import com.bold.skycast.presentation.model.DayVisualize
import com.bold.skycast.presentation.model.ForecastDayVisualize
import com.bold.skycast.presentation.model.WeatherConditionVisualize

@Composable
fun ForecastItem(
    forecastDayVisualize: ForecastDayVisualize,
    modifier: Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Column {
                Text(
                    text = forecastDayVisualize.dayName,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = forecastDayVisualize.date,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF78909C)
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = forecastDayVisualize.day.condition.text,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                AsyncImage(
                    modifier = Modifier.size(48.dp),
                    model = "https:${forecastDayVisualize.day.condition.icon}",
                    contentDescription = "",
                    contentScale = ContentScale.FillHeight
                )
            }

            Text(
                text = "${forecastDayVisualize.day.averageTemperature}°",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForecastItemPreview() {
    val forecastDayVisualize = ForecastDayVisualize(
        date = "01/02",
        dayName = "Lunes",
        day = DayVisualize(
            averageTemperature = 74f,
            condition = WeatherConditionVisualize(
                text = "Moderate rain",
                icon = "icon",
                code = 0
            )
        )
    )
    ForecastItem(
        forecastDayVisualize = forecastDayVisualize,
        modifier = Modifier
    )
}