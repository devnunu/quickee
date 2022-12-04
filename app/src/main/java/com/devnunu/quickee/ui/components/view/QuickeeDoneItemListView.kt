package com.devnunu.quickee.ui.components.view

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.quickee.data.model.QuickeeItem
import com.devnunu.quickee.ext.clickableNonRipple
import com.devnunu.quickee.ui.MainState
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun QuickeeDoneItemListView(
    modifier: Modifier = Modifier,
    state: MainState,
    onClickOpenDoneListView: () -> Unit,
    onSelectedItem: (QuickeeItem) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        AnimatedVisibility(
            visible = state.isOpenDoneListView,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 150.dp)
                    .verticalScroll(rememberScrollState())
                    .background(Color.Black)
                    .padding(top = 20.dp, start = 15.dp, end = 15.dp)
            ) {
                state.doneItemList.forEachIndexed { index, item ->
                    val isSelectedItem = state.hasSelectedItem && state.selectedItem == item
                    Row(
                        modifier = Modifier
                            .height(IntrinsicSize.Min)
                            .padding(bottom = 6.dp)
                            .clickableNonRipple { onSelectedItem(item) },
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
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 5.dp, vertical = 3.dp),
                            text = item.value,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = if(isSelectedItem) Color.White else Color.Gray
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .clickableNonRipple {
                    onClickOpenDoneListView()
                }
                .padding(15.dp),
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
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }
    }
}