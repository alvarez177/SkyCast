package com.bold.skycast.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ForecastSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFF1EEEE),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 10.dp)
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "3 días de pronostico",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF263238)
        )

        ForecastItem(modifier = Modifier.padding(horizontal = 5.dp))
        Spacer(modifier = Modifier.height(10.dp))
        ForecastItem(modifier = Modifier.padding(horizontal = 5.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun ForecastSectionPreview() {
    ForecastSection()
}