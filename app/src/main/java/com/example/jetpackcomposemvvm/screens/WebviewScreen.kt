package com.example.jetpackcomposemvvm.screens

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.viewinterop.AndroidView
import com.example.jetpackcomposemvvm.mvvm.WebviewViewModel


@Composable
fun WebViewScreen(viewModel: WebviewViewModel) {
    val url = "https://google.com"
    val isDataUpdated by viewModel.isDataUpdated.collectAsState()

    if (isDataUpdated) {
        LaunchedEffect(Unit) {
            viewModel.firebaseUpdateWebview()
        }
    }

    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}