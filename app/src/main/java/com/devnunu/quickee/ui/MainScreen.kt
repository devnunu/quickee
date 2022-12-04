package com.devnunu.quickee.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.components.QuickeeScaffold
import com.devnunu.quickee.theme.QuickeeTheme
import com.devnunu.quickee.ui.components.QuickeeDoneItemListView
import com.devnunu.quickee.ui.components.QuickeeInProgressItemListView
import com.devnunu.quickee.ui.components.view.SelectedSubFeatureBottomView
import com.devnunu.quickee.ui.components.bottomSheet.MainBottomSheet
import com.devnunu.quickee.ui.components.bottomSheet.MainBottomSheetTag
import com.devnunu.quickee.ui.components.view.CommonSubFeatureBottomView
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = koinViewModel(),
    onBackPressed: () -> Unit
) {
    val state by viewModel.collectAsState()

    BackHandler(
        onBack = {
            if (state.isShowBottomSheet) {
                viewModel.onChangeBottomSheetState(null)
            } else {
                onBackPressed()
            }
        }
    )
    QuickeeTheme {
        QuickeeScaffold(
            isShowBottomSheet = state.isShowBottomSheet,
            onDismissBottomSheet = {
                viewModel.onChangeBottomSheetState(null)
            },
            bottomSheetContent = {
                MainBottomSheet(viewModel = viewModel)
            }
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
                        onClickDoneItem = viewModel::onClickDoneItem,
                        onClickDeleteItem = viewModel::onClickDeleteItem
                    )
                } else {
                    CommonSubFeatureBottomView(
                        modifier = Modifier.fillMaxWidth(),
                        onClickInputBtn = {
                            viewModel.onChangeBottomSheetState(MainBottomSheetTag.INPUT)
                        }
                    )
                }
                Divider(
                    thickness = 1.dp,
                    color = Color.LightGray
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
    MainScreen(
        onBackPressed = {}
    )
}