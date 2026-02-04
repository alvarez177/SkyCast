package com.bold.skycast.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bold.skycast.presentation.model.LocationVisualize

@Composable
fun LocationSearchBar(
    query: String,
    isSearching: Boolean,
    locationResultIsLoading: Boolean = false,
    results: List<LocationVisualize>,
    searchLocationsErrorMessage: String?,
    onLocationSelected: (LocationVisualize) -> Unit,
    onQueryChange: (String) -> Unit
    ) {
    Column {
        OutlinedTextField(
            value = query,
            onValueChange = {
                onQueryChange(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            placeholder = {
                Text("Buscar ubicación")
            },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp)
        )

        when {
            locationResultIsLoading -> {
                SearchLocationLoader()
            }
            searchLocationsErrorMessage != null -> {
                ErrorSearchLocationResult(searchLocationsErrorMessage)
            }
            results.isNotEmpty() -> {
                LazyColumn {
                    items(results) { locationVisualize: LocationVisualize ->
                        LocationResultItem(
                            locationVisualize = locationVisualize,
                            onClick = onLocationSelected
                        )
                    }
                }
            }
            isSearching && results.isEmpty() -> {
                EmptyLocationResult()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LocationSearchBarPreview() {
    LocationSearchBar(
        query = "",
        isSearching = false,
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
        onLocationSelected = {},
        onQueryChange = {}
    )
}