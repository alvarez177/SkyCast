package com.bold.skycast.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EmptyLocationResult() {
    Text(
        text = "No se encontraron resultados",
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}

@Preview(showBackground = true)
@Composable
fun EmptyLocationResultPreview() {
    EmptyLocationResult()
}