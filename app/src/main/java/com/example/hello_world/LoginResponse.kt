package com.example.hello_world

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")var message:String,
    @SerializedName("access_token")var access_token:String

)