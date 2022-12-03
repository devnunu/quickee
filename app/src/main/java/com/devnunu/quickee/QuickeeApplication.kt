package com.devnunu.quickee

import android.app.Application
import com.devnunu.quickee.di.uiModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

class QuickeeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            module { uiModule }
        }
    }
}