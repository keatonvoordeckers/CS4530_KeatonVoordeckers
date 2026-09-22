package com.example.assignment2courseviewereditorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.assignment2courseviewereditorapp.ui.theme.Assignment2CourseViewerEditorAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Assignment2CourseViewerEditorAppTheme {
                val navCon = rememberNavController()

                MyAppNav(
                    myNavController = navCon,
                    startDestination = "courseList"
                )
            }
        }
    }
}