package ir.mirdar.pexelmovieapp.presentation

enum class Screen {
    DISCOVERY,
    SPLASH
}
sealed class NavigationItem(val route: String) {
    data object Discovery : NavigationItem(Screen.DISCOVERY.name)
    data object Splash : NavigationItem(Screen.SPLASH.name)
}