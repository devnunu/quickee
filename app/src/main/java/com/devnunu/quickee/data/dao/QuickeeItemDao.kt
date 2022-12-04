package com.devnunu.quickee.data.dao

import androidx.room.*
import com.devnunu.quickee.data.model.QuickeeItem
import kotlinx.coroutines.flow.Flow

@Dao
interface QuickeeItemDao {

    @Query("SELECT * FROM items")
    fun getQuickeeItemList(): Flow<List<QuickeeItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuickeeItem(item: QuickeeItem)

    @Delete
    fun deleteQuickeeItem(item: QuickeeItem)

    @Query("UPDATE items SET isDone = 1 WHERE id = :id")
    fun updateQuickeeItemDone(id: Int)
}