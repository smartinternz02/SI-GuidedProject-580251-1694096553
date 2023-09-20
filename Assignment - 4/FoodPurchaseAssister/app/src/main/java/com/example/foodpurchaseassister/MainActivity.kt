package com.example.foodpurchaseassister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodpurchaseassister.ui.theme.FoodPurchaseAssisterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodPurchaseAssisterTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    // Define Composables for each screen
                    composable("login") {
                        Login(navController)
                    }
                    composable("hotel") {
                        Hotel(navController)
                    }
                    composable("food") {
                        Food(navController)
                    }
                    composable("purchase") {
                        Purchase(navController)
                    }
                }
            }
        }
    }
}
