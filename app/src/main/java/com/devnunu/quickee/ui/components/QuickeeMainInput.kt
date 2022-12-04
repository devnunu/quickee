package com.devnunu.quickee.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.devnunu.quickee.ui.MainState

@Composable
fun QuickeeMainInput(
    modifier: Modifier = Modifier,
    state: MainState,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = modifier
    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = null
        )
        BasicTextField(
            value = state.inputValue.orEmpty(),
            onValueChange = onValueChange
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuickeeMainInputPreview() {
    QuickeeMainInput(
        state = MainState(),
        onValueChange = {}
    )
}