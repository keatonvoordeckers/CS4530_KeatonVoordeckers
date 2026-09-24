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

        composable("editCourse/{courseId}") { backStackEntry ->
            val courseId = backStackEntry.arguments
                ?.getString("courseId")
                ?.toIntOrNull() ?: return@composable

            EditCourseScreen(myNavController, model, courseId)
        }

        composable("courseDetails/{courseId}") { backStackEntry ->
            val courseId = backStackEntry.arguments
                ?.getString("courseId")
                ?.toIntOrNull() ?: return@composable

            CourseDetailsScreen(myNavController, model, courseId)
        }
    }
}