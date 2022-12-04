package com.devnunu.quickee.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devnunu.quickee.data.dao.QuickeeItemDao
import com.devnunu.quickee.data.model.QuickeeItem

@Database(entities = [QuickeeItem::class], version = 3, exportSchema = false)
abstract class QuickeeDatabase : RoomDatabase() {
    abstract fun quickeeItemDao(): QuickeeItemDao
}