package com.devnunu.quickee.common

import android.app.Application
import com.devnunu.quickee.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class QuickeeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@QuickeeApplication)
            modules(uiModule)
        }
    }
}