package ir.mirdar.pexelmovieapp.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.mirdar.pexelmovieapp.presentation.common.BaseActivity
import ir.mirdar.pexelmovieapp.presentation.discovery.HomeAction
import ir.mirdar.pexelmovieapp.presentation.discovery.HomeIntent
import ir.mirdar.pexelmovieapp.presentation.discovery.HomeState
import ir.mirdar.pexelmovieapp.presentation.theme.PexelTheme
@AndroidEntryPoint
class MainActivity : BaseActivity<HomeIntent, HomeAction, HomeState>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            PexelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost(
                        navController = navController,
                        startDestination = NavigationItem.Splash.route
                    )
                }
            }
        }

    }

}