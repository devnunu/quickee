package com.devnunu.quickee.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.quickee.ui.MainState
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun QuickeeDoneItemListView(
    modifier: Modifier = Modifier,
    state: MainState
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(15.dp),
    ) {
        FlowRow(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            state.doneItemList.forEachIndexed { index, item ->
                Row(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
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
                            .padding(horizontal = 5.dp, vertical = 3.dp),
                        text = item.value,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(14.dp),
                imageVector = Icons.Default.Done,
                contentDescription = null,
                tint = Color.Gray
            )
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = "${state.doneItemCount} items has been done",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}