package com.example.hello_world

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var client = OkHttpClient.Builder().build()
    var retrofit: Retrofit? = Retrofit.Builder()
        .baseUrl("https://courses-service.herokuapp.com").addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            fun <T> buildService(Service: Class<T>): T? {
                return retrofit?.create(Service)

            }



}