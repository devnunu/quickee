package com.devnunu.quickee.di

import com.devnunu.quickee.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    viewModel { MainViewModel(get()) }
}