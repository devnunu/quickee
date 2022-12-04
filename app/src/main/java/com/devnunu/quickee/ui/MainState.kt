package com.devnunu.quickee.ui

import com.devnunu.quickee.data.model.QuickeeItem

data class MainState(
    val inputValue: String? = null,
    val selectedItem: QuickeeItem? = null,
    val inProgressItemList: List<QuickeeItem> = emptyList(),
    val doneItemList: List<QuickeeItem> = emptyList()
) {
    val doneItemCount: Int
        get() = doneItemList.count()
}