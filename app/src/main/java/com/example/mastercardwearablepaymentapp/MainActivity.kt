package com.example.mastercardwearablepaymentapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mastercardwearablepaymentapp.onboarding.presentation.coverscreen.CoverScreen
import com.example.mastercardwearablepaymentapp.onboarding.presentation.gridscreen.GridScreen
import com.example.mastercardwearablepaymentapp.onboarding.presentation.introscreen.IntroScreen
import com.example.mastercardwearablepaymentapp.onboarding.presentation.productscreen.ProductsScreen
import com.example.mastercardwearablepaymentapp.onboarding.presentation.termsandconditionscreen.TermsAndConditionScreen
import com.example.mastercardwearablepaymentapp.ui.theme.MastercardWearablePaymentAppTheme
import com.example.mastercardwearablepaymentapp.util.Event
import com.example.mastercardwearablepaymentapp.util.EventBus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MastercardWearablePaymentAppTheme {
                val lifecycle = LocalLifecycleOwner.current.lifecycle
                LaunchedEffect(key1 = lifecycle) {
                    repeatOnLifecycle(
                        state = Lifecycle.State.STARTED
                    ) {
                        EventBus.events.collect {
                            event ->
                            if (event is Event.Toast) {
                                Toast.makeText(
                                    this@MainActivity,
                                    event.message,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(Modifier.padding(innerPadding), navController)
                }
            }
        }
    }
}


@Composable
fun App(modifier: Modifier, navController: NavHostController) {
    // Page Router
    NavHost(
        navController = navController, startDestination = Screen.GridScreen.route
    ) {
        composable(Screen.CoverScreen.route) {
            CoverScreen (navController) {
            }
        }

        composable(Screen.IntroScreen.route) {
            IntroScreen(navController) {
            }
        }

        composable(Screen.TermsAndConditionScreen.route) {
            TermsAndConditionScreen(navController) {
            }
        }

         composable(Screen.ProductsScreen.route) {
             ProductsScreen(navController)
         }

        composable(Screen.GridScreen.route) {
            GridScreen(navController)
        }
    }
}