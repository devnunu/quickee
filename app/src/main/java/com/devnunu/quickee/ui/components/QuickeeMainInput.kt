package com.devnunu.quickee.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.ext.clickableNonRipple
import com.devnunu.quickee.theme.ROTATE_DURATION
import com.devnunu.quickee.ui.MainState

@Composable
fun QuickeeMainInput(
    modifier: Modifier = Modifier,
    state: MainState,
    onValueChange: (String) -> Unit,
    onClickEditIcon: () -> Unit
) {

    var currentRotation by remember { mutableStateOf(0f) }
    val rotation = remember { Animatable(currentRotation) }

    LaunchedEffect(state.isInputMode) {
        if (state.isInputMode) {
            rotation.animateTo(
                targetValue = 45f,
                animationSpec = tween(
                    durationMillis = ROTATE_DURATION,
                    easing = LinearEasing
                )
            ) {
                currentRotation = value
            }
        } else {
            rotation.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = ROTATE_DURATION,
                    easing = LinearEasing
                )
            ) {
                currentRotation = value
            }
        }
    }

    Row(
        modifier = modifier
    ) {
        Icon(
            modifier = Modifier
                .size(45.dp, 45.dp)
                .rotate(rotation.value)
                .clickableNonRipple { onClickEditIcon() },
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        BasicTextField(
            value = state.inputValue.orEmpty(),
            onValueChange = onValueChange
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuickeeMainInputPreview() {
    QuickeeMainInput(
        state = MainState(),
        onValueChange = {}
    ) {}
}