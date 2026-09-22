package com.example.assignment2courseviewereditorapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.assignment2courseviewereditorapp.model.Course

class CourseViewModel : ViewModel() {
    // List backing
    var courses by mutableStateOf<List<Course>>(emptyList())

    //
    fun addCourse(course: Course){
        courses += course
    }

    //
    fun editCourse(course: Course){
        courses.get(course.id - 1).id = course.id
        courses.get(course.id - 1).department = course.department
        courses.get(course.id - 1).courseNumber = course.courseNumber
        courses.get(course.id - 1).location = course.location
    }

    //
    fun removeCourse(course: Course){
        courses -= course
    }
}
