package com.example.assignment2courseviewereditorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.assignment2courseviewereditorapp.model.Course
import com.example.assignment2courseviewereditorapp.viewmodel.CourseViewModel

@Composable
fun CourseDetailsScreen(myNavController : NavHostController, model : CourseViewModel, courseId : Int?) {
    val course = model.courses.firstOrNull { it.id == courseId }

    if (course == null) {
        Text("Course not found")
        return
    }

    LazyColumn(modifier = Modifier.padding(horizontal = 25.dp, vertical = 100.dp)
        .fillMaxSize()
        .background(Color.LightGray, RoundedCornerShape(5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 10.dp),
        userScrollEnabled = false) {

        item{
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Department:",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(text = course.department,
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(20))
                    .fillMaxWidth()
            )

            Text(text = "Course Number:",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(text = course.courseNumber,
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(20))
                    .fillMaxWidth()
            )

            Text(text = "Location:",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(text = course.location,
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(20))
                    .fillMaxWidth()
            )


        }
    }

    Button(onClick = { myNavController.navigate("courseList") },
        modifier = Modifier.absoluteOffset(40.dp,825.dp)
            .size(100.dp, 55.dp)
    ) {
        Text(text = "Back")
    }

    Text(modifier = Modifier.statusBarsPadding().fillMaxWidth(), textAlign = TextAlign.Center, text = "Course Details")
}