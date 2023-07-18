package com.example.jetpackcomposemvvm.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.jetpackcomposemvvm.R
import com.example.jetpackcomposemvvm.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, currentTime: Int) {

    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1500,
                easing = {
                    OvershootInterpolator(2.5f).getInterpolation(it)
                }
            )
        )
        delay(3000L)

        val destination = if (currentTime in 9..11) {
            Screens.WebviewScreen.route
        } else {
            Screens.TestScreen.route
        }
        navController.popBackStack()
        navController.navigate(destination)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.scale(scale.value)
        )
    }
}