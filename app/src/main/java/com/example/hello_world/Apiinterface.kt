package com.example.hello_world

import okhttp3.Call
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface Apiinterface {
    @POST("register")
    fun registerStudent(@Body requestBody:RequestBody  ): Call<RegistrationResponse>
}