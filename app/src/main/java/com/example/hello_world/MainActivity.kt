package com.example.hello_world

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val intent = Intent(baseContext,CourseActivity::class.java)
            startActivity(intent)

            val email = textView4.text.toString()
            val password = editTextPassword.text

            if(email.isEmpty()){
                textView4.error = "email is required"
            }

            if(password.isNullOrEmpty()){
                editTextPassword.error = "Password is required"
            }
        }
        var progress = 0
        progressBar2.setOnClickListener {
            if(progress < 100){
                progress +=20
            } else{
                progress = 0
                progressBar2.progress = progress
                progressBar2.visibility = View.INVISIBLE
            }
        }

        val email = textView4.text.toString()
        val password = editTextPassword.text

        val requestBody =MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("name",email)
            .addFormDataPart("password", password.toString())

    }
    fun loginStudents(requestBody:RequestBody){
    val apiClient=ApiClient.buildService(Apiinterfacelogin::class.java)
        val loginCall= apiClient?.loginStudent(requestBody)
        loginCall?.enqueue(object : retrofit2.Callback<LoginResponse> {
            override fun onFailure(call: retrofit2.Call<LoginResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    var accessToken = response.body()?.access_token
                    var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
                    var editor = sharedPreferences.edit()
                    editor.putString("ACCESS_TOKEN_KEY", accessToken)
                    editor.apply()
                    val intent = Intent(baseContext, CourseActivity::class.java)
                    startActivity(intent)
                    finish()
                } else{
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}