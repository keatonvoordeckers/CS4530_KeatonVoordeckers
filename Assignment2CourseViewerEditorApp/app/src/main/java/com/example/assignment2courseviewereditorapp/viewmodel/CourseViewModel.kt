package com.example.assignment2courseviewereditorapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.assignment2courseviewereditorapp.model.Course

class CourseViewModel : ViewModel() {
    // List backing
    var courses by mutableStateOf<List<Course>>(emptyList())

    var id by mutableStateOf(0)

    //
    fun addCourse(course : Course){
        course.id = id++
        courses += course
    }

    //
    fun editCourse(old_course: Course, new_course: Course){
        old_course.department = new_course.department
        old_course.courseNumber = new_course.courseNumber
        old_course.location = new_course.location
    }

    //
    fun removeCourse(course: Course){
        courses -= course
    }
}
