package com.example.hello_world

import android.media.session.MediaSession
import okhttp3.Call
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface Apiinterface {
    @POST("register")
    fun registerStudent(@Body requestBody:RequestBody  ): retrofit2.Call<RegistrationResponse>

    @GET("login")
    fun getCourses(@Header("Authorization")accessToken: String): retrofit2.Call<CourseResponse>
}