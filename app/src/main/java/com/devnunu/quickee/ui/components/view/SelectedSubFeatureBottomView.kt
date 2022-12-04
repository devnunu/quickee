package com.devnunu.quickee.ui.components.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.data.model.QuickeeItem
import com.devnunu.quickee.ui.MainState
import com.devnunu.quickee.ui.components.btn.SubFeatureIconBtn

@Composable
fun SelectedSubFeatureBottomView(
    modifier: Modifier = Modifier,
    state: MainState,
    onClickDoneItem: (QuickeeItem) -> Unit,
    onClickDeleteItem: (QuickeeItem) -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 15.dp, vertical = 15.dp)
    ) {
        Spacer(
            modifier = Modifier.weight(1f)
        )
        SubFeatureIconBtn(
            modifier = Modifier.padding(end = 10.dp),
            imageVector = Icons.Default.Done,
            background = Color.Green,
            onClickBtn = {
                state.selectedItem?.let {
                    onClickDoneItem(it)
                }
            }
        )
        SubFeatureIconBtn(
            imageVector = Icons.Default.Delete,
            background = Color.Red,
            onClickBtn = {
                state.selectedItem?.let {
                    onClickDeleteItem(it)
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SelectedSubFeatureBottomViewPreview() {
    SelectedSubFeatureBottomView(
        state = MainState(),
        onClickDoneItem = {},
        onClickDeleteItem = {}
    )
}