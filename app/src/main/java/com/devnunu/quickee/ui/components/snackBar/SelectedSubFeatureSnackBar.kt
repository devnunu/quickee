package com.devnunu.quickee.ui.components.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.data.model.QuickeeItem
import com.devnunu.quickee.ui.MainState
import com.devnunu.quickee.ui.components.btn.SubFeatureIconBtn
import com.devnunu.quickee.ui.components.btn.SubFeatureIconWithTextBtn

@Composable
fun SelectedSubFeatureSnackBar(
    modifier: Modifier = Modifier,
    state: MainState,
    onClickDoneItem: (QuickeeItem) -> Unit,
    onClickDeleteItem: (QuickeeItem) -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 15.dp, vertical = 15.dp)
    ) {
        SubFeatureIconBtn(
            imageVector = Icons.Default.Delete,
            background = Color.LightGray,
            onClickBtn = {
                state.selectedItem?.let {
                    onClickDeleteItem(it)
                }
            }
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        SubFeatureIconWithTextBtn(
            imageVector = Icons.Default.KeyboardArrowDown,
            background = Color.LightGray,
            onClickBtn = {
                state.selectedItem?.let {
                    onClickDoneItem(it)
                }
            },
            text = "DONE"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SelectedSubFeatureBottomViewPreview() {
    SelectedSubFeatureSnackBar(
        state = MainState(),
        onClickDoneItem = {},
        onClickDeleteItem = {}
    )
}