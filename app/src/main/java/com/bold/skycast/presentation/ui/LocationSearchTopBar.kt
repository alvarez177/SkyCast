package com.bold.skycast.presentation.ui

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationSearchTopBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            LocationSearchBar(
                query = query,
                onQueryChange = onQueryChange
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LocationSearchTopBarPreview() {
    LocationSearchTopBar(
        query = "Medellin"
    ) { }
}