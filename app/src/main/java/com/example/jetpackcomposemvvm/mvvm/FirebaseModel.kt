package com.example.jetpackcomposemvvm.mvvm

data class FirebaseModel(
    val appOpens: Int,
    val testOpens:Int,
    val webViewOpens:Int
) {
    constructor() : this(0, 0, 0)
}
