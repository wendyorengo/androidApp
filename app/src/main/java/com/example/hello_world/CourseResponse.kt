package com.example.hello_world

import com.google.gson.annotations.SerializedName

data class CourseResponse(
    @SerializedName("courses")var courses: List<Courses>
)