package com.example.hello_world

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_registration.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        button2.setOnClickListener {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
            val firstName = textView2.text.toString()
            val lastName = textView3.text.toString()
            val email = textView4.text.toString()
            val password = editTextPassword.text.toString()
            val phoneNumber = editTextPassword.text.toString()


            var requestBody= MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("first_name",firstName)
                    .addFormDataPart("last_name",lastName)
                    .addFormDataPart("email",email)
                    .addFormDataPart("password",password)
                    .addFormDataPart("phone_number",phoneNumber)
                    .build()
            if(firstName.isEmpty()){
                textView2.error = "FirstName is required"
            }
            if(lastName.isEmpty()){
                textView3.error = "LastName is required"
            }
            if(email.isBlank()){
                textView4.error = "Email is required"
            }
            if(password.isBlank()){
                editTextPassword.error = "password is required"
            }
            if(phoneNumber.isEmpty()){
                editTextPassword.error = "PhoneNumber is required"
            }


        }
    }
    fun registerStudents(requestBody : RequestBody){
        var apiClient=ApiClient.buildService(Apiinterface::class.java)
        val registrationCall= apiClient?.registerStudent(requestBody)
        registrationCall?.enqueue(object : Callback<RegistrationResponse>{
            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<RegistrationResponse>,
                response: Response<RegistrationResponse>
            ) {
                if(response.isSuccessful){
                    Toast.makeText(baseContext,response.body()?.message,Toast.LENGTH_LONG).show()
                    val intent=Intent(baseContext,MainActivity::class.java)
                    startActivity(intent)
                } else{
                    Toast.makeText(baseContext,response.errorBody().toString(),Toast.LENGTH_LONG).show()
                }
            }

        })
    }
}
