package com.example.hello_world

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "courses")

data class Course(
    @PrimaryKey @SerializedName("course_id")val CourseId: String,
    @SerializedName("course_name")val CourseName: String,
    @SerializedName("course_code")val CourseCode: String,
    @SerializedName("instructor") val instructor: String,
    @SerializedName("description")val description: String

)