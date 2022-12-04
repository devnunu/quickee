package com.devnunu.quickee.ui

import com.devnunu.quickee.data.model.QuickeeItem
import com.devnunu.quickee.ui.components.bottomSheet.MainBottomSheetTag

data class MainState(
    val showBottomSheetTag: MainBottomSheetTag? = null,
    val isOpenDoneListView: Boolean = false,
    val inputValue: String? = null,
    val selectedItem: QuickeeItem? = null,
    val inProgressItemList: List<QuickeeItem> = emptyList(),
    val doneItemList: List<QuickeeItem> = emptyList()
) {
    val doneItemCount: Int
        get() = doneItemList.count()

    val isShowBottomSheet: Boolean
        get() = showBottomSheetTag != null
}