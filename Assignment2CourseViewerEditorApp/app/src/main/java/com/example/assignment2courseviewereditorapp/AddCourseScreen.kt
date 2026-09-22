package com.example.assignment2courseviewereditorapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.navigation.NavHostController
import com.example.assignment2courseviewereditorapp.model.Course
import com.example.assignment2courseviewereditorapp.viewmodel.CourseViewModel

@Composable
fun AddCourseScreen(myNavController : NavHostController, model : CourseViewModel) {
    LazyColumn(Modifier.fillMaxWidth().statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        item{
            Row{
                Text("Add Course")
            }

            var department by remember { mutableStateOf("") }
            var courseNumber by remember { mutableStateOf("")}
            var location by remember { mutableStateOf("")}
            val course = Course(
                id = 0,
                department = "",
                courseNumber = "",
                location = ""
                )

            // Department input
            Row{
                OutlinedTextField(
                    value = department,
                    onValueChange = { newDepartment ->  department = newDepartment },
                    label = { Text("Department") }
                )
                course.department = department
            }

            // Course Number input
            Row{
                OutlinedTextField(
                    value = courseNumber,
                    onValueChange = { newCourseNumber -> courseNumber = newCourseNumber},
                    label = { Text("Course Number")}
                )
                course.courseNumber = courseNumber
            }

            // Location input
            Row{
                OutlinedTextField(
                    value = location,
                    onValueChange = { newLocation -> location = newLocation},
                    label = { Text("Location") }
                )
                course.location = location
            }

            Row{
                Button(onClick = {
                    if (department.isNotBlank() &&
                        courseNumber.isNotBlank() &&
                        location.isNotBlank()){
                        model.addCourse(course)
                        myNavController.navigate("courseList")
                    } else {
                        myNavController.navigate("courseList")
                    }
                }
                ) {
                    Text("Add")
                }
            }

            Row{
                Button(onClick = { myNavController.navigate("courseList") } ) {
                    Text("Back")
                }
            }
        }
    }
}