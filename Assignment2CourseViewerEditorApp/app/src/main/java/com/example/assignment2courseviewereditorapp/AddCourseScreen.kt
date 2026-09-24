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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.assignment2courseviewereditorapp.model.Course
import com.example.assignment2courseviewereditorapp.viewmodel.CourseViewModel
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.OutlinedTextFieldDefaults

@Composable
fun AddCourseScreen(myNavController : NavHostController, model : CourseViewModel) {
    var department by remember { mutableStateOf("") }
    var courseNumber by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    val course = Course(
        id = 0,
        department = "",
        courseNumber = "",
        location = ""
    )

    LazyColumn(modifier = Modifier.padding(horizontal = 25.dp, vertical = 100.dp)
        .fillMaxSize()
        .background(Color.LightGray, RoundedCornerShape(5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        userScrollEnabled = false) {

        // Department input
        item {
            Row {
                OutlinedTextField(
                    value = department,
                    onValueChange = { newDepartment -> department = newDepartment },
                    label = { Text(text = "Department") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
                course.department = department
            }

            // Course Number input
            Row {
                OutlinedTextField(
                    value = courseNumber,
                    onValueChange = { newCourseNumber -> courseNumber = newCourseNumber },
                    label = { Text(text = "Course Number") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
                course.courseNumber = courseNumber
            }

            // Location input
            Row {
                OutlinedTextField(
                    value = location,
                    onValueChange = { newLocation -> location = newLocation },
                    label = { Text(text = "Location") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
                course.location = location
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                if (department.isNotBlank() &&
                    courseNumber.isNotBlank() &&
                    location.isNotBlank()
                ) {
                    model.addCourse(course)
                    myNavController.navigate("courseList")
                } else {
                    myNavController.navigate("courseList")
                }},
                modifier = Modifier.size(100.dp, 55.dp)
            ) {
                Text(text = "Add")
            }
        }
    }

    Button(onClick = { myNavController.navigate("courseList") },
        modifier = Modifier.absoluteOffset(40.dp,825.dp)
            .size(100.dp, 55.dp)
    ) {
        Text(text = "Back")
    }

    Text(modifier = Modifier.statusBarsPadding().fillMaxWidth(), textAlign = TextAlign.Center, text = "Add Course")
}