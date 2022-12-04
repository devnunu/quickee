package com.devnunu.quickee.ui.components.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.ext.clickableNonRipple

@Composable
fun CommonSubFeatureBottomView(
    modifier: Modifier = Modifier,
    onClickInputBtn: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 15.dp, vertical = 15.dp)
    ) {
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Icon(
            modifier = Modifier
                .background(Color.LightGray, RoundedCornerShape(5.dp))
                .padding(horizontal = 12.dp, vertical = 3.dp)
                .size(18.dp)
                .clickableNonRipple {
                    onClickInputBtn()
                },
            imageVector = Icons.Default.Edit,
            contentDescription = null,
            tint = Color.White
        )
    }
}