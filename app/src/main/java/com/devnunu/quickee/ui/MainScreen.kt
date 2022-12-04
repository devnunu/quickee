package com.devnunu.quickee.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.theme.QuickeeTheme
import com.devnunu.quickee.ui.components.QuickeeDoneItemListView
import com.devnunu.quickee.ui.components.QuickeeMainInput
import com.devnunu.quickee.ui.components.QuickeeInProgressItemListView
import com.devnunu.quickee.ui.components.SelectedSubFeatureBottomView
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
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                QuickeeInProgressItemListView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                        .padding(10.dp),
                    state = state,
                    onSelectedItem = viewModel::onSelectedItem
                )
                if (state.selectedItem != null) {
                    SelectedSubFeatureBottomView(
                        modifier = Modifier.fillMaxWidth(),
                        state = state,
                        onClickDeleteItem = viewModel::onClickDeleteItem
                    )
                }
                Divider(
                    thickness = 1.dp,
                    color = Color.LightGray
                )
                QuickeeMainInput(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp),
                    state = state,
                    onValueChange = viewModel::onChangeInputValue,
                    onClickDoneBtn = viewModel::onClickDoneBtn
                )
                QuickeeDoneItemListView(
                    state = state
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}