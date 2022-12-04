package com.devnunu.quickee.common

import android.app.Application
import com.devnunu.quickee.di.dataModule
import com.devnunu.quickee.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class QuickeeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@QuickeeApplication)
            modules(
                uiModule,
                dataModule
            )
        }
    }
}