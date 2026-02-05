package com.bold.skycast.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bold.skycast.presentation.model.WeatherType
import com.bold.skycast.ui.theme.weatherBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationSearchTopBar(
    query: String,
    isSearching: Boolean,
    weatherType: WeatherType,
    onClearQuery: () -> Unit,
    onQueryChange: (String) -> Unit
) {
    val backgroundColors = weatherBackground(weatherType)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(backgroundColors)
            )
    ) {
        CenterAlignedTopAppBar(
            title = {
                LocationSearchBar(
                    query = query,
                    isSearching = isSearching,
                    onClearQuery = onClearQuery,
                    onQueryChange = onQueryChange
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LocationSearchTopBarPreview() {
    LocationSearchTopBar(
        query = "Medellin",
        isSearching = true,
        weatherType = WeatherType.FOG,
        onClearQuery = {}
    ) { }
}