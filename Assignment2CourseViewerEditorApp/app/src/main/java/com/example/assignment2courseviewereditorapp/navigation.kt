package com.example.assignment2courseviewereditorapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyAppNav(
    myNavController: NavHostController,
    startDestination: String = "courseList"
) {
    NavHost(
        navController = myNavController,
        startDestination = startDestination
    ) {
        composable("courseList") {
            CourseListScreen(myNavController)
        }

        composable("addCourse") {
            AddCourseScreen(myNavController, model)
        }

        composable("editCourse/{model}/{courseId}") { backStackEntry ->
            val courseId = backStackEntry.arguments
                ?.getString("courseId")
                ?.toIntOrNull()

            EditCourseScreen(
                myNavController,
                model,
                courseId
            )
        }

        composable("courseDetails/{model}/{courseId}") { backStackEntry ->
            val courseId = backStackEntry.arguments
                ?.getString("courseId")
                ?.toIntOrNull()

            CourseDetailsScreen(
                myNavController,
                model,
                courseId
            )
        }
    }
}