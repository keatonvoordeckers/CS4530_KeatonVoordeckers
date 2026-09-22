package com.example.assignment2courseviewereditorapp

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.assignment2courseviewereditorapp.viewmodel.CourseViewModel

val model = CourseViewModel()

@Composable
fun CourseListScreen(myNavController : NavHostController) {

    LazyColumn(modifier = Modifier.padding(horizontal = 25.dp, vertical = 50.dp).fillMaxSize().background(Color.Gray, RoundedCornerShape(5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        userScrollEnabled = true) {

        items(model.courses) { course ->
            Row(Modifier.background(Color.LightGray, RoundedCornerShape(10))
                .clickable(enabled = true, onClick = { myNavController.navigate("courseDetails/${course.id}") })){

                Spacer(modifier = Modifier.width(10.dp))

                Column{
                    Text("Course: " + course.department + " " + course.courseNumber)
                    Text("Location: " + course.location)
                }

                Spacer(modifier = Modifier.width(75.dp))

                Button(onClick = { myNavController.navigate("editCourse/${course.id}") } ) {
                    Text("Edit")
                }

                Button(onClick = { myNavController.navigate("removeCourse/${course.id}") }) {
                    Text("X")
                }

                Spacer(modifier = Modifier.width(10.dp))
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }

    Button(modifier = Modifier.absoluteOffset(300.dp, 800.dp), onClick = { myNavController.navigate("addCourse") }) {
        Text(text = "+")
    }

    Text(modifier = Modifier.statusBarsPadding().fillMaxWidth(), textAlign = TextAlign.Center, text = "Course List")
}