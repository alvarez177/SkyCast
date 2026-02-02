package com.bold.skycast.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LocationSearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = { },
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
}

@Preview(showBackground = true)
@Composable
fun LocationSearchBarPreview() {
    LocationSearchBar()
}