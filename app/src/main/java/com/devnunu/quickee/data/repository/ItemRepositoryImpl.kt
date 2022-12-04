package com.devnunu.quickee.data.repository

import com.devnunu.quickee.data.model.QuickeeItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ItemRepositoryImpl : ItemRepository {

    private val quickeeItemList = MutableStateFlow<List<QuickeeItem>>(emptyList())

    override fun getQuickeeItemList(): StateFlow<List<QuickeeItem>> =
        quickeeItemList

    override fun addQuickeeItem(item: QuickeeItem) {
        val itemList = quickeeItemList.value.toMutableList()
        itemList.add(0, item)
        quickeeItemList.value = itemList
    }

    override fun deleteQuickeeItem(item: QuickeeItem) {
        val itemList = quickeeItemList.value.toMutableList()
        itemList.remove(item)
        quickeeItemList.value = itemList
    }

    override fun updateQuickeeItemDone(item: QuickeeItem) {
        val itemList = quickeeItemList.value
        val index = itemList.indexOf(item)
        if (index >= 0) {
            itemList.getOrNull(index)?.isDone = true
        }
        quickeeItemList.value = itemList
    }
}