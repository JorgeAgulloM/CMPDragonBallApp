package com.example.dragonballapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.dragonballapp.ui.detail.DetailScreen
import com.example.dragonballapp.ui.home.HomeScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen { id ->
                navController.navigate(Detail(id = id))
            }
        }
        composable<Detail> { navBackStackEntry ->
            val detail = navBackStackEntry.toRoute<Detail>()
            val id = detail.id
            DetailScreen(id = id) {
                navController.popBackStack()
            }
        }
    }
}
