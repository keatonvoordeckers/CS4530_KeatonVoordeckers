package com.example.assignment2courseviewereditorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.assignment2courseviewereditorapp.model.Course
import com.example.assignment2courseviewereditorapp.viewmodel.CourseViewModel

@Composable
fun EditCourseScreen(myNavController : NavHostController, model : CourseViewModel, courseId : Int?) {
    LazyColumn(modifier = Modifier.padding(horizontal = 25.dp, vertical = 100.dp)
        .fillMaxSize()
        .background(Color.LightGray, RoundedCornerShape(5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        userScrollEnabled = true) {

        //
    }

    Button(onClick = { myNavController.navigate("courseList") },
        modifier = Modifier.absoluteOffset(40.dp,825.dp)
            .size(100.dp, 55.dp)
    ) {
        Text(text = "Back")
    }

    Text(modifier = Modifier.statusBarsPadding().fillMaxWidth(), textAlign = TextAlign.Center, text = "Edit Course")
}