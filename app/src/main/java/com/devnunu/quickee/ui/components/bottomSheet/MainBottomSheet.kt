package com.devnunu.quickee.ui.components.bottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.devnunu.quickee.ui.MainViewModel
import org.orbitmvi.orbit.compose.collectAsState

enum class MainBottomSheetTag {
    INPUT
}

@Composable
fun MainBottomSheet(viewModel: MainViewModel) {
    val state by viewModel.collectAsState()

    when (state.showBottomSheetTag) {
        MainBottomSheetTag.INPUT -> {
            MainInputBottomSheet(
                state = state,
                onValueChange = viewModel::onChangeInputValue,
                onClickDoneBtn = viewModel::onClickDoneBtn
            )
        }
        else -> Unit
    }
}