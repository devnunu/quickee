package com.devnunu.quickee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.devnunu.quickee.navigation.QuickeeNavHost
import com.devnunu.quickee.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickeeNavHost(onBackPressed = { finishAndRemoveTask() })
        }
    }
}