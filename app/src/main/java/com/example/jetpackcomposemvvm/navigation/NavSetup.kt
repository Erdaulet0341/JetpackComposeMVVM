package com.example.jetpackcomposemvvm.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposemvvm.screens.SplashScreen
import com.example.jetpackcomposemvvm.screens.TestScreen
import com.example.jetpackcomposemvvm.mvvm.TestViewModel
import com.example.jetpackcomposemvvm.screens.WebViewScreen
import com.example.jetpackcomposemvvm.mvvm.WebviewViewModel
import java.util.Calendar

@Composable
fun NavigationSetup(navController: NavHostController, testViewModel: TestViewModel, webviewViewModel: WebviewViewModel) {
    val currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    Log.d("MyTag", currentTime.toString())

    NavHost(navController = navController, startDestination = Screens.Splash.route) {
        composable(Screens.Splash.route) {
            SplashScreen(navController, currentTime)
        }
        composable(Screens.WebviewScreen.route) {
            WebViewScreen(webviewViewModel)
        }
        composable(Screens.TestScreen.route) {
            TestScreen(testViewModel)
        }
    }
}