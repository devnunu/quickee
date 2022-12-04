package com.devnunu.quickee.data.repository

import com.devnunu.quickee.data.dao.QuickeeItemDao
import com.devnunu.quickee.data.model.QuickeeItem
import kotlinx.coroutines.flow.Flow

class ItemRepositoryImpl(
    private val quickeeItemDao: QuickeeItemDao
) : ItemRepository {

    override fun getQuickeeItemList(): Flow<List<QuickeeItem>> =
        quickeeItemDao.getQuickeeItemList()

    override fun addQuickeeItem(item: QuickeeItem) {
        quickeeItemDao.addQuickeeItem(item)
    }

    override fun deleteQuickeeItem(item: QuickeeItem) {
        quickeeItemDao.deleteQuickeeItem(item)
    }

    override fun updateQuickeeItemDone(item: QuickeeItem, isDone: Boolean) {
        item.id?.let { id ->
            quickeeItemDao.updateQuickeeItemDone(id, isDone)
        }
    }

    override fun updateQuickeeItemValue(item: QuickeeItem, value: String) {
        item.id?.let { id ->
            quickeeItemDao.updateQuickeeItemValue(id, value)
        }
    }
}