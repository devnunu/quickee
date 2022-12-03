package com.devnunu.quickee.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devnunu.quickee.navigation.QuickeeRoute.MAIN
import com.devnunu.quickee.ui.MainScreen

@Composable
fun QuickeeNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MAIN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MAIN) {
            MainScreen()
        }
    }
}

object QuickeeRoute {
    const val MAIN = "main"
}