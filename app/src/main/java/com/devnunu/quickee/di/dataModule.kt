package com.devnunu.quickee.di

import com.devnunu.quickee.data.repository.ItemRepository
import com.devnunu.quickee.data.repository.ItemRepositoryImpl
import org.koin.dsl.module

val dataModule = module {

    single<ItemRepository> {
        ItemRepositoryImpl()
    }
}