package ir.mirdar.pexelmovieapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.mirdar.pexelmovieapp.presentation.discovery.DiscoveryScreen
import ir.mirdar.pexelmovieapp.presentation.detail.ImageDetailScreen
import ir.mirdar.pexelmovieapp.presentation.screens.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Splash.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Splash.route) {
            SplashScreen(navController)
        }
        composable(NavigationItem.Discovery.route) {
            DiscoveryScreen(navController)
        }

        composable(
            "detail/{photoId}",
            arguments = listOf(navArgument("photoId") { type = NavType.LongType })
        ) { backStack ->
            val photoId = backStack.arguments?.getLong("photoId") ?: 0
            ImageDetailScreen(navController, photoId)
        }
    }
}