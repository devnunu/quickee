package com.devnunu.quickee.di

import androidx.room.Room
import com.devnunu.quickee.data.dao.QuickeeItemDao
import com.devnunu.quickee.data.database.QuickeeDatabase
import com.devnunu.quickee.data.repository.ItemRepository
import com.devnunu.quickee.data.repository.ItemRepositoryImpl
import org.koin.dsl.module

val dataModule = module {

    single<ItemRepository> {
        ItemRepositoryImpl(get())
    }
}