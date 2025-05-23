package com.example.mastercardwearablepaymentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mastercardwearablepaymentapp.ui.theme.MastercardWearablePaymentAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MastercardWearablePaymentAppTheme {
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
        navController = navController, startDestination = Screen.CoverScreen.route
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
    }
}