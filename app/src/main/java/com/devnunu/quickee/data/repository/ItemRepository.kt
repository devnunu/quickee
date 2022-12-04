package com.devnunu.quickee.data.repository

import com.devnunu.quickee.data.model.QuickeeItem

interface ItemRepository {
    fun getQuickeeInProgressItemList(): List<QuickeeItem>

    fun getQuickeeDoneItemList(): List<QuickeeItem>
}