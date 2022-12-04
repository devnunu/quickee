package com.devnunu.quickee.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.quickee.ext.clickableNonRipple
import com.devnunu.quickee.theme.QuickeeTheme
import com.devnunu.quickee.ui.components.QuickeeMainInput
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MainScreen(
    viewModel: MainViewModel = koinViewModel()
) {
    val state by viewModel.collectAsState()

    QuickeeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    state.itemList.forEach { item ->
                        Row(
                            modifier = Modifier
                                .padding(end = 10.dp)
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
                                        viewModel.onClickDeleteItem(item)
                                    },
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                            )
                        }
                    }
                }
                Divider(
                    thickness = 1.dp,
                    color = Color.LightGray
                )
                QuickeeMainInput(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp),
                    state = state,
                    onValueChange = viewModel::onChangeInputValue,
                    onClickEditIcon = viewModel::onClickEditIcon,
                    onClickDoneBtn = viewModel::onClickDoneBtn
                )
            }
        }
    }
}