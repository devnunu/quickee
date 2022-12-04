package com.devnunu.quickee.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.quickee.ext.expand
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun QuickeeScaffold(
    isShowBottomSheet: Boolean = false,
    onDismissBottomSheet: (() -> Unit)? = null,
    bottomSheetContent: (@Composable (ColumnScope) -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    LaunchedEffect(isShowBottomSheet) {
        scope.launch {
            if (isShowBottomSheet) {
                bottomSheetState.expand()
            } else {
                bottomSheetState.hide()
            }
        }
    }
    LaunchedEffect(bottomSheetState.isVisible) {
        if(!bottomSheetState.isVisible) {
            onDismissBottomSheet?.invoke()
        }
    }
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Spacer(modifier = Modifier.height(1.dp))
            bottomSheetContent?.let {
                bottomSheetContent(this)
            }
        },
    ) {
        content()
    }
}
