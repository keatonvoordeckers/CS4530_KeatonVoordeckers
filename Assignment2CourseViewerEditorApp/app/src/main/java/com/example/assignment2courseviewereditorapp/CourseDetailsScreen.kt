package com.example.assignment2courseviewereditorapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun CourseDetailsScreen(myNavController : NavHostController, courseId : Int?) {
    LazyColumn(Modifier.fillMaxWidth().statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        item {
            Row{
                Text("Details")
            }

            Row{
                Button(onClick = { myNavController.navigate("courseList") } ) {
                    Text("Back")
                }
            }
        }

    }
}