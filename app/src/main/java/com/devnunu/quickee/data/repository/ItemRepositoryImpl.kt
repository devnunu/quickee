package com.devnunu.quickee.data.repository

import com.devnunu.quickee.data.model.QuickeeItem

class ItemRepositoryImpl : ItemRepository {

    private val quickeeItemList: List<QuickeeItem> = emptyList()

    override fun getQuickeeInProgressItemList(): List<QuickeeItem> =
        quickeeItemList.filter { !it.isDone }

    override fun getQuickeeDoneItemCount(): Int =
        quickeeItemList.count { it.isDone }
}