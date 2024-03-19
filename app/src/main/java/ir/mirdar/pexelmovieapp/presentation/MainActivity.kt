package ir.mirdar.pexelmovieapp.presentation

import android.os.Bundle
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.mirdar.pexelmovieapp.presentation.common.BaseActivity
import ir.mirdar.pexelmovieapp.presentation.common.HomeAction
import ir.mirdar.pexelmovieapp.presentation.common.HomeIntent
import ir.mirdar.pexelmovieapp.presentation.common.HomeState
import ir.mirdar.pexelmovieapp.presentation.theme.BazaarSampleTheme
@AndroidEntryPoint
class MainActivity : BaseActivity<HomeIntent, HomeAction, HomeState>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BazaarSampleTheme {
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
            BackHandler {
                finish()
            }
        }

    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BazaarSampleTheme {
        Greeting("Android")
    }
}