package com.devnunu.quickee.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.ext.clickableNonRipple
import com.devnunu.quickee.theme.PurpleGrey80
import com.devnunu.quickee.ui.MainState

@Composable
fun QuickeeMainInput(
    modifier: Modifier = Modifier,
    state: MainState,
    onValueChange: (String) -> Unit,
    onClickDoneBtn: () -> Unit
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            modifier = Modifier
                .focusRequester(focusRequester = focusRequester)
                .weight(1f)
                .padding(start = 15.dp, end = 15.dp),
            singleLine = true,
            value = state.inputValue.orEmpty(),
            onValueChange = onValueChange,
        )
        Icon(
            modifier = Modifier
                .size(45.dp, 45.dp)
                .padding(5.dp)
                .background(PurpleGrey80, RoundedCornerShape(20.dp))
                .padding(5.dp)
                .clickableNonRipple { onClickDoneBtn() },
            imageVector = Icons.Default.Done,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuickeeMainInputPreview() {
    QuickeeMainInput(
        state = MainState(),
        onValueChange = {},
        onClickDoneBtn = {}
    )
}