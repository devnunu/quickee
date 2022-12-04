package com.devnunu.quickee.ui.components.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.quickee.data.model.QuickeeItem
import com.devnunu.quickee.ext.clickableNonRipple
import com.devnunu.quickee.ui.MainState
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun QuickeeInProgressItemListView(
    modifier: Modifier = Modifier,
    state: MainState,
    onSelectedItem: (QuickeeItem) -> Unit
) {
    FlowRow(
        modifier = modifier,
    ) {
        state.inProgressItemList.forEachIndexed { index, item ->
            val isSelectedItem = (state.hasSelectedItem && state.selectedItem == item)
                    || (state.selectedItem?.isDone ?: true)
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .clickableNonRipple { onSelectedItem(item) }
                    .padding(bottom = 3.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (index != 0) {
                    Divider(
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .height(10.dp)
                            .width(1.5.dp),
                        color = Color.Gray,
                    )
                }
                val textColor = if (isSelectedItem) Color.White else Color.LightGray
                Text(
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 3.dp),
                    text = item.value,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuickeeInProgressItemListViewPreview() {
    QuickeeInProgressItemListView(
        state = MainState(
            inProgressItemList = listOf(
                QuickeeItem(value = "clean"),
                QuickeeItem(value = "go to market"),
                QuickeeItem(value = "buy a book"),
            )
        ),
        onSelectedItem = {}
    )
}
