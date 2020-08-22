package com.example.hello_world

import android.telecom.Call
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST


interface Apiinterfacelogin {
    @POST("login")
    fun loginStudent(@Body requestBody: RequestBody) : retrofit2.Call<LoginResponse>
}