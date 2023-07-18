package com.example.jetpackcomposemvvm.screens

import com.example.jetpackcomposemvvm.ui.theme.Green80
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposemvvm.R
import com.example.jetpackcomposemvvm.mvvm.TestViewModel

@Composable
fun TestScreen(viewModel: TestViewModel) {

    val hello by viewModel.hello.collectAsState()
    val isDataUpdated by viewModel.isDataUpdated.collectAsState()

    if (isDataUpdated) {
        LaunchedEffect(Unit) {
            viewModel.firebaseUpdate()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello",
                color = Color.DarkGray,
                fontSize = 30.sp,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mers),
                    contentDescription = "kaz",
                    modifier = Modifier.size(64.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.mers),
                    contentDescription = "eng",
                    modifier = Modifier.size(64.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.mers),
                    contentDescription = "rus",
                    modifier = Modifier.size(64.dp)
                )
            }
            Button(
                onClick = {
                    viewModel.onButtonClick()
                },
                modifier = Modifier.padding(bottom = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White, containerColor = Green80
                )
            ) {
                Text(text = "Button")
            }
            Text(
                text = hello,
                color = Color.DarkGray,
                fontSize = 30.sp,
            )
        }
    }
}
