package com.Manuel.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost


import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.Manuel.login.screens.LoginScreen
import com.Manuel.login.screens.SingUpScreen
import com.Manuel.login.screens.WelcomeScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Welcome"
    ){
        composable("Welcome") {
            WelcomeScreen(navController = navController)
        }

        composable("SingUp") {
            SingUpScreen(navController = navController)
        }

        composable("Login") {
            LoginScreen(navController = navController)
        }
    }
}
