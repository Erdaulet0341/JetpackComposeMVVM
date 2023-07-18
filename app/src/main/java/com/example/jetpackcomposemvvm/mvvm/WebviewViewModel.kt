package com.example.jetpackcomposemvvm.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WebviewViewModel : ViewModel() {

    private val _isDataUpdated = MutableStateFlow(true)
    val isDataUpdated: StateFlow<Boolean> = _isDataUpdated

    fun firebaseUpdateWebview() {
        val reference = FirebaseDatabase.getInstance().getReference("opens")
        reference.get().addOnSuccessListener { dataSnapshot ->
            val firebaseModelOld = dataSnapshot.getValue(FirebaseModel::class.java)
            var appOpens = firebaseModelOld?.appOpens ?: 0
            val testOpens = firebaseModelOld?.testOpens ?: 0
            val webViewOpens = firebaseModelOld?.webViewOpens ?: 0
            val firebaseModel = FirebaseModel(appOpens + 1, testOpens, webViewOpens+1)
            reference.setValue(firebaseModel).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("MyTag", "Data updated successfully")
                    _isDataUpdated.value = false
                } else {
                    Log.d("MyTag", task.exception.toString())
                }
            }
        }
    }
}
