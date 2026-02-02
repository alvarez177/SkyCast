package com.bold.skycast.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SkyCastScreen() {
    Scaffold { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(horizontal = 8.dp)) {
            LocationSearchBar()
            CurrentWeatherStateSection()
            Spacer(modifier = Modifier.height(10.dp))
            ForecastSection()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SkyCastScreenPreview() {
    SkyCastScreen()
}