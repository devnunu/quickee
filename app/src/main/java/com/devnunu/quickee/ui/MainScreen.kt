package com.devnunu.quickee.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.components.QuickeeScaffold
import com.devnunu.quickee.ext.clickableNonRipple
import com.devnunu.quickee.theme.QuickeeTheme
import com.devnunu.quickee.ui.components.view.QuickeeDoneItemListView
import com.devnunu.quickee.ui.components.view.QuickeeInProgressItemListView
import com.devnunu.quickee.ui.components.snackBar.SelectedSubFeatureSnackBar
import com.devnunu.quickee.ui.components.bottomSheet.MainBottomSheet
import com.devnunu.quickee.ui.components.snackBar.DoneSubFeatureSnackBar
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
                    .fillMaxSize()
                    .background(Color.DarkGray)
                    .clickableNonRipple { viewModel.onClickEmptyArea() },
            ) {
                QuickeeInProgressItemListView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 20.dp, vertical = 30.dp),
                    state = state,
                    onSelectedItem = viewModel::onSelectedItem
                )
                Column(
                    modifier = Modifier.heightIn(min = 60.dp)
                ) {
                    AnimatedVisibility(
                        visible = state.isOpenInProgressItemSnackBar,
                        enter = slideInVertically(initialOffsetY = { it }),
                        exit = slideOutVertically(targetOffsetY = { it })
                    ) {
                        SelectedSubFeatureSnackBar(
                            modifier = Modifier.fillMaxWidth(),
                            state = state,
                            onClickChangeSortOrder = viewModel::onClickChangeSortOrder,
                            onClickEditItem = viewModel::onClickEditItem,
                            onClickDoneItem = viewModel::onClickDoneItem,
                            onClickDeleteItem = viewModel::onClickDeleteItem
                        )
                    }
                    AnimatedVisibility(
                        visible = state.isOpenDoneItemSnackBar,
                        enter = slideInVertically(initialOffsetY = { it }),
                        exit = slideOutVertically(targetOffsetY = { it })
                    ) {
                        DoneSubFeatureSnackBar(
                            modifier = Modifier.fillMaxWidth(),
                            state = state,
                            onClickDeleteItem = viewModel::onClickDeleteItem,
                            onClickRestoreBtn = viewModel::onClickRestoreBtn
                        )
                    }
                }
                QuickeeDoneItemListView(
                    state = state,
                    onClickOpenDoneListView = viewModel::onClickOpenDoneListView,
                    onSelectedItem = viewModel::onSelectedItem
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