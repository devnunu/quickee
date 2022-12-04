package com.devnunu.quickee.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.quickee.ext.clickableNonRipple
import com.devnunu.quickee.ui.MainState
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun QuickeeMainItemListView(
    modifier: Modifier = Modifier,
    state: MainState,
    onClickDeleteItem: (String) -> Unit
) {
    FlowRow(
        modifier = modifier
    ) {
        state.itemList.forEach { item ->
            Row(
                modifier = Modifier
                    .padding(end = 10.dp, bottom = 10.dp)
                    .background(Color.LightGray, RoundedCornerShape(10.dp))
                    .padding(horizontal = 5.dp, vertical = 3.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item,
                    fontSize = 10.sp
                )
                Icon(
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .size(10.dp)
                        .clickableNonRipple {
                            onClickDeleteItem(item)
                        },
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
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
        onClickDeleteItem = {}
    )
}
