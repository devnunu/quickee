package com.devnunu.quickee.data.repository

import com.devnunu.quickee.data.model.QuickeeItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ItemRepository {

    fun getQuickeeItemList(): Flow<List<QuickeeItem>>

    fun addQuickeeItem(item: QuickeeItem)

    fun deleteQuickeeItem(item: QuickeeItem)

    fun updateQuickeeItemDone(item: QuickeeItem, isDone: Boolean)

    fun updateQuickeeItemValue(item: QuickeeItem, value: String)
}