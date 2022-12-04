package com.devnunu.quickee.ui.components.btn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.quickee.ext.clickableNonRipple

@Composable
fun SubFeatureIconWithTextBtn(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    background: Color,
    tint: Color = Color.White,
    text: String,
    onClickBtn: () -> Unit,
) {
    Row(
        modifier = modifier
            .background(background, RoundedCornerShape(6.dp))
            .padding(start = 6.dp, end = 10.dp, top = 3.dp, bottom = 3.dp)
            .clickableNonRipple {
                onClickBtn()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = modifier.size(20.dp),
            imageVector = imageVector,
            contentDescription = null,
            tint = tint
        )
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
    }
}