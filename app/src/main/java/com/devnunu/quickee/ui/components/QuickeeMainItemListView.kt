package com.devnunu.quickee.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.quickee.ext.clickableNonRipple
import com.devnunu.quickee.ui.MainState
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

@Composable
fun QuickeeMainItemListView(
    modifier: Modifier = Modifier,
    state: MainState,
    onSelectedItem: (String) -> Unit
) {
    FlowRow(
        modifier = modifier,
        mainAxisSize = SizeMode.Expand
    ) {
        state.itemList.forEachIndexed { index, item ->
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .clickableNonRipple { onSelectedItem(item) }
                    .padding(vertical = 3.dp),
            ) {
                if (index != 0) {
                    Divider(
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .fillMaxHeight()
                            .width(1.dp),
                        color = Color.LightGray,
                    )
                }
                Text(
                    modifier = Modifier
                        .composed {
                            if (state.selectedItem == item) {
                                this.background(Color.LightGray, RoundedCornerShape(10.dp))
                            } else this
                        }
                        .padding(horizontal = 5.dp, vertical = 3.dp),
                    text = item,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuickeeMainItemListViewPreview() {
    QuickeeMainItemListView(
        state = MainState(
            itemList = listOf("clean", "go to market", "buy a book")
        ),
        onSelectedItem = {}
    )
}
