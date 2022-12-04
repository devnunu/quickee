package com.devnunu.quickee.ui.components.snackBar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.data.model.QuickeeItem
import com.devnunu.quickee.ui.MainState
import com.devnunu.quickee.ui.components.btn.SubFeatureIconBtn
import com.devnunu.quickee.ui.components.btn.SubFeatureIconWithTextBtn

@Composable
fun DoneSubFeatureSnackBar(
    modifier: Modifier = Modifier,
    state: MainState,
    onClickRestoreBtn: (QuickeeItem) -> Unit,
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
            imageVector = Icons.Default.KeyboardArrowUp,
            background = Color.LightGray,
            onClickBtn = {
                state.selectedItem?.let {
                    onClickRestoreBtn(it)
                }
            },
            text = "RESTORE"
        )
    }
}