package com.example.jetpackcomposemvvm.navigation

sealed class Screens(val route: String) {
    object Splash : Screens("splash_screen")
    object WebviewScreen : Screens("webview_screen")
    object TestScreen : Screens("test_screen")
}
