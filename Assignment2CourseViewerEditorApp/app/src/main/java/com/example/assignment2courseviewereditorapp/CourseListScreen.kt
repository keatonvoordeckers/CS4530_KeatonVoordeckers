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
import androidx.compose.foundation.layout.size

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

    LazyColumn(modifier = Modifier.padding(horizontal = 25.dp, vertical = 100.dp)
        .fillMaxSize()
        .background(Color.LightGray, RoundedCornerShape(5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {

        items(model.courses) { course ->

            Spacer(modifier = Modifier.height(10.dp))

            Row(Modifier.background(Color.White, RoundedCornerShape(10))
                .clickable(enabled = true, onClick = { myNavController.navigate("courseDetails/${model}/${course.id}") })
                .size(350.dp,75.dp)
                .animateItem()

            ){
                Spacer(modifier = Modifier.width(10.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text ="Course: ${course.department} ${course.courseNumber}")
                    Text(text = "Location: ${course.location}")
                }

                Column{
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = { myNavController.navigate("editCourse/${model}/${course.id}") },
                        modifier = Modifier.size(100.dp, 55.dp)
                    ) {
                        Text(text = "Edit")
                    }
                }

                Spacer(modifier = Modifier.width(5.dp))

                Column{
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = { model.removeCourse(course) },
                        modifier = Modifier.size(55.dp, 55.dp)
                    ) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "x")
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }

    Button(onClick = { myNavController.navigate("addCourse") },
        modifier = Modifier.absoluteOffset(320.dp, 825.dp)
            .size(55.dp, 55.dp)
    ) {
        Text(text = "+")
    }

    Text(modifier = Modifier.statusBarsPadding().fillMaxWidth(), textAlign = TextAlign.Center, text = "Course List")
}