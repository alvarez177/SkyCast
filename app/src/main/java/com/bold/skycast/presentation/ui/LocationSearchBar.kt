package com.bold.skycast.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LocationSearchBar(
    query: String,
    isSearching: Boolean,
    onClearQuery: () -> Unit,
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
            trailingIcon = {
                if (isSearching) {
                    IconButton(onClick = onClearQuery) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Limpiar búsqueda"
                        )
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LocationSearchBarPreview() {
    LocationSearchBar(
        query = "",
        isSearching = true,
        onClearQuery = {},
        onQueryChange = {}
    )
}