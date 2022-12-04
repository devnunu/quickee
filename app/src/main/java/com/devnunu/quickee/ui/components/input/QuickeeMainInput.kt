package com.devnunu.quickee.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.ui.MainState

@Composable
fun QuickeeMainInput(
    modifier: Modifier = Modifier,
    state: MainState,
    onValueChange: (String) -> Unit,
    onClickRegisterBtn: () -> Unit
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(start = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            modifier = Modifier
                .focusRequester(focusRequester = focusRequester)
                .weight(1f)
                .padding(horizontal = 10.dp, vertical = 15.dp),
            singleLine = true,
            value = state.inputValue.orEmpty(),
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    onClickRegisterBtn()
                }
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuickeeMainInputPreview() {
    QuickeeMainInput(
        state = MainState(),
        onValueChange = {},
        onClickRegisterBtn = {}
    )
}