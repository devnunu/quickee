package com.devnunu.quickee.ui

import com.devnunu.quickee.data.model.QuickeeItem

data class MainState(
    val inputValue: String? = null,
    val selectedItem: QuickeeItem? = null,
    val itemList: List<QuickeeItem> = emptyList()
) {
}