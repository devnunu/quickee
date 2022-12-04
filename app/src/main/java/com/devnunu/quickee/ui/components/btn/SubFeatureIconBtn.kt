package com.devnunu.quickee.ui.components.btn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.ext.clickableNonRipple

@Composable
fun SubFeatureIconBtn(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    background: Color,
    tint: Color = Color.White,
    onClickBtn: () -> Unit,
) {
    Icon(
        modifier = modifier
            .background(background, RoundedCornerShape(5.dp))
            .padding(horizontal = 12.dp, vertical = 5.dp)
            .size(18.dp)
            .clickableNonRipple {
                onClickBtn()
            },
        imageVector = imageVector,
        contentDescription = null,
        tint = tint
    )
}