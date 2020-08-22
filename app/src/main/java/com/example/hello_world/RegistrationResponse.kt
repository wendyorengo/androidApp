package com.example.hello_world

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    @SerializedName("message")var message:String,
    @SerializedName("student")var student: Student

    )