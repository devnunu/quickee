package com.devnunu.quickee.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.devnunu.quickee.theme.QuickeeTheme
import com.devnunu.quickee.ui.components.QuickeeMainInput
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MainScreen(
    viewModel: MainViewModel = koinViewModel()
) {
    val state by viewModel.collectAsState()

    QuickeeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                QuickeeMainInput(
                    modifier = Modifier.fillMaxWidth(),
                    state = state,
                    onValueChange = viewModel::onChangeInputValue,
                    onClickEditIcon = viewModel::onClickEditIcon
                )
            }
        }
    }
}