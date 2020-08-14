package com.example.hello_world

import okhttp3.Call
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface Apiinterfacelogin {
    @POST("login")
    fun loginStudent(@Body requestBody: RequestBody) : Call<LoginResponse>
}