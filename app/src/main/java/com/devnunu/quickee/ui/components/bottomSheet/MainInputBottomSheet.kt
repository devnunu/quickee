package com.devnunu.quickee.ui.components.bottomSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.devnunu.quickee.ui.MainState
import com.devnunu.quickee.ui.components.QuickeeMainInput

@Composable
fun MainInputBottomSheet(
    state: MainState,
    onValueChange: (String) -> Unit,
    onClickDoneBtn: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        QuickeeMainInput(
            state = state,
            onValueChange = onValueChange,
            onClickDoneBtn = onClickDoneBtn
        )
    }
}