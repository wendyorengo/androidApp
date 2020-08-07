package com.example.hello_world

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_course.*
import kotlinx.android.synthetic.main.row_course_item.*

data class Courses(val course_id:Int, val course_name:String, val course_code:Int, val instructor:String, val description:String)
class CourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        val coursesAdapter = CoursesRecyclerViewAdapter(coursesList = listOf(
            Courses(1,"Kotlin",10,"John","Mobile development"),
        Courses(2,"python",20,"Mwai","backend development"),
        Courses(3,"Html",30,"Jeff","Frontend layout"),
        Courses(4,"pd-development",40,"Rodgers","Personal dev"),
            Courses(5,"Navigate",50,"Veroh","life-management"),
            Courses(6,"entrepreneurship",60,"Gatwiri","business models"),
            Courses(7,"js",70,"Purity","api"),
            Courses(8,"design",80,"Nyandia","good lookin things"),
            Courses(9,"h.design",90,"Barre","3d modelling"),
            Courses(10,"h.electronics",100,"Barre","system development")
        ))
        rvCourses.adapter = coursesAdapter

    }
}