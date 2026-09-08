package com.example.cs4530_lecture4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat.enableEdgeToEdge


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KeatonApp()
        }
    }
}
@Composable
fun KeatonApp() {
    var text1 by remember { mutableStateOf("") } // First input
    var text2 by remember { mutableStateOf("") } // Second input
    var result by remember { mutableStateOf("") } // Combined Result

    // Create Column to store TextFields, Buttons, and the result Text
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // TextField One
        OutlinedTextField(
            value = text1,
            onValueChange = {text1 = it}
        )
        // TextField Two
        OutlinedTextField(
            value = text2,
            onValueChange = {text2 = it}
        )
        // Button to combine inputs
        Button(onClick = { result = text1 + text2 }) {
            Text("Combine")
        }

        Text(result) // Show result

    }
}
