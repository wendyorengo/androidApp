package com.example.hello_world

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_course.*
import kotlinx.android.synthetic.main.row_course_item.*
import okhttp3.Call
import okhttp3.Response
import retrofit2.Callback

data class Courses(val course_id:Int, val course_name:String, val course_code:Int, val instructor:String, val description:String)
class CourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
//
        fetchCourses()

    }

    fun fetchCourses(){
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken  = sharedPreferences.getString("ACCESS_TOKEN_KEY","")

        val apiClient = ApiClient.buildService(Apiinterface::class.java)
        var coursesCall = apiClient?.getCourses("Bearer$accessToken")
        coursesCall?.enqueue(object : Callback<CourseResponse>{
            override fun onFailure(call: retrofit2.Call<CourseResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call : retrofit2.Call<CourseResponse>, response: retrofit2.Response<CourseResponse>){
                if(response.isSuccessful){
                    var courseList =  response.body()?.courses as List<Courses>
                    var coursesAdapter = CoursesRecyclerViewAdapter(courseList)
                    rvCourses.layoutManager = LinearLayoutManager(baseContext)
                    rvCourses.adapter = coursesAdapter
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })



    }
}