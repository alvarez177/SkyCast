package com.bold.skycast.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bold.skycast.R

@Composable
fun CurrentWeatherStateSection() {
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
                text = "Girardota",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF546E7A)
            )

            Text(
                text = "72°",
                fontSize = 64.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF263238)
            )

            Text(
                text = "Partly cloudy",
                fontSize = 16.sp,
                color = Color(0xFF78909C)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_cloud_rain),
                contentDescription = null,
                modifier = Modifier.size(96.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurrentWeatherStateSectionPreview() {
    CurrentWeatherStateSection()
}