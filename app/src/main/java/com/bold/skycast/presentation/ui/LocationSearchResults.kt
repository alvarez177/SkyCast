package com.bold.skycast.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.bold.skycast.presentation.model.LocationVisualize

@Composable
fun LocationSearchResults(
    isSearching: Boolean,
    locationResultIsLoading: Boolean,
    results: List<LocationVisualize>,
    searchLocationsErrorMessage: String?,
    onLocationSelected: (LocationVisualize) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .zIndex(1f),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        when {
            locationResultIsLoading -> {
                SearchLocationLoader()
            }
            searchLocationsErrorMessage != null -> {
                ErrorSearchLocationResult(searchLocationsErrorMessage)
            }
            results.isNotEmpty() -> {
                LazyColumn(
                    modifier = Modifier.heightIn(max = 300.dp)
                ) {
                    items(results) { location ->
                        LocationResultItem(
                            locationVisualize = location,
                            onClick = onLocationSelected
                        )
                    }
                }
            }
            isSearching -> {
                EmptyLocationResult()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LocationSearchResultsPreview() {
    LocationSearchResults(
        isSearching = false,
        locationResultIsLoading = false,
        results = listOf(
            LocationVisualize(
                id = 0,
                name = "Medellin",
                region = "Antioquia",
                country = "Colombia"
            ),
            LocationVisualize(
                id = 0,
                name = "Girardota",
                region = "Antioquia",
                country = "Colombia"
            )
        ),
        searchLocationsErrorMessage = null,
        onLocationSelected = {}
    )
}
