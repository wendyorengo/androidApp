package com.example.hello_world

import com.google.gson.annotations.SerializedName

data class Course(
    @SerializedName("course_id")val CourseId: String,
    @SerializedName("course_name")val CourseName: String,
    @SerializedName("course_code")val CourseCode: String,
    @SerializedName("instructor") val instructor: String,
    @SerializedName("description")val description: String

)