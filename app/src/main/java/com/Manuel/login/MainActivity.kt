package com.Manuel.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.Manuel.login.navigation.AppNavigation
import com.Manuel.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginTheme {
                AppNavigation()
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   // LoginScreen(modifier = Modifier.padding(innerPadding))
                    //Login(modifier = Modifier.padding(innerPadding))
                    //CreateAccount(modifier = Modifier.padding(innerPadding))

            }
        }
    }
}

