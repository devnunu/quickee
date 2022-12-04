package com.devnunu.quickee.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class QuickeeItem(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "value") val value: String,
    @ColumnInfo(name = "isDone") var isDone: Boolean = false,
    @ColumnInfo(name = "modifiedAt") val modifiedAt: Long = System.currentTimeMillis()
)
