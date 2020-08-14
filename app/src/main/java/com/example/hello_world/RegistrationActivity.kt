package com.example.hello_world

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.*
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_registration.view.*
import okhttp3.Call
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.Response
import retrofit2.Callback

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        button2.setOnClickListener{
            val intent = Intent(baseContext,MainActivity::class.java)
            startActivity(intent)
            var firstName = textView2.text.toString()
            var lastName = textView3.text.toString()
            var email = textView4.text.toString()
            var password = editTextPassword.text
            var phoneNumber = editTextPassword.text
            var passwordConfirm = textView5.text.toString()
            var forgotPassword = textViewForgotPassword.text.toString()

            var requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("first_name", firstName)
                .addFormDataPart("last_name",lastName)
                .addFormDataPart("email",email)
                .addFormDataPart("phone_number", phoneNumber.toString())
                .addFormDataPart("password", password.toString())
                .build()

            registerUser(requestBody)
            makeText(baseContext, lastName, LENGTH_SHORT).show()
    }
      }
    fun registerUser(requestBody: RequestBody) {6
        var apiClient = ApiClient.buildService(Apiinterface::class.java)
        var registrationCall = apiClient?.registerStudent(requestBody)
        registrationCall.enqueue(object : Callback<RegistrationResponse> {
            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<RegistrationResponse>,
                response: Response<RegistrationResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    startActivity(Intent(baseContext, MainActivity::class.java))
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }

}

