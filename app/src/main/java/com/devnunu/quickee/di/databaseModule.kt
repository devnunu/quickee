package com.devnunu.quickee.di

import androidx.room.Room
import com.devnunu.quickee.data.database.QuickeeDatabase
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(get(), QuickeeDatabase::class.java, "quickee.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<QuickeeDatabase>().quickeeItemDao()
    }
}