package com.devnunu.quickee.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.data.model.QuickeeItem
import com.devnunu.quickee.ext.clickableNonRipple
import com.devnunu.quickee.ui.MainState

@Composable
fun SelectedSubFeatureBottomView(
    modifier: Modifier = Modifier,
    state: MainState,
    onClickDeleteItem: (QuickeeItem) -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 15.dp, vertical = 15.dp)
    ) {
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Icon(
            modifier = Modifier
                .background(Color.LightGray, RoundedCornerShape(5.dp))
                .padding(horizontal = 12.dp, vertical = 3.dp)
                .size(18.dp)
                .clickableNonRipple {
                    state.selectedItem?.let {
                        onClickDeleteItem(it)
                    }
                },
            imageVector = Icons.Default.Delete,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SelectedSubFeatureBottomViewPreview() {
    SelectedSubFeatureBottomView(
        state = MainState(),
        onClickDeleteItem = {}
    )
}