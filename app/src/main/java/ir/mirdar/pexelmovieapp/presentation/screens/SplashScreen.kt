package ir.mirdar.pexelmovieapp.presentation.screens

import AvailableScreen
import UnAvailableScreen
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import ir.mirdar.pexelmovieapp.presentation.NavigationItem
import ir.mirdar.pexelmovieapp.presentation.helper.ConnectionState
import ir.mirdar.pexelmovieapp.presentation.helper.currentConnectivityStatus
import ir.mirdar.pexelmovieapp.presentation.helper.observeConnectivityAsFlow

@Composable
fun SplashScreen(
    navController: NavController
) {

    val connection by connectivityStatus()

    val isConnected = connection === ConnectionState.Available

    if (isConnected) {
        navController.navigate(NavigationItem.Discovery.route)
    }
    Scaffold {
        if (isConnected) {
            AvailableScreen()
        } else {
            UnAvailableScreen()
        }
    }
}


@Composable
fun connectivityStatus(): State<ConnectionState> {
    val context = LocalContext.current

    return produceState(initialValue = context.currentConnectivityStatus) {
        context.observeConnectivityAsFlow().collect { value = it }
    }
}