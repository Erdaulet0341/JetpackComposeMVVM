package com.example.jetpackcomposemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposemvvm.mvvm.TestViewModel
import com.example.jetpackcomposemvvm.mvvm.WebviewViewModel
import com.example.jetpackcomposemvvm.navigation.NavigationSetup
import com.example.jetpackcomposemvvm.ui.theme.JetpackComposeMVVMTheme

class MainActivity : ComponentActivity() {
    private val testViewModel: TestViewModel by viewModels()
    private val webviewViewModel: WebviewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeMVVMTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val navController = rememberNavController()
                    NavigationSetup(navController, testViewModel, webviewViewModel)
                }
            }
        }
    }
}
