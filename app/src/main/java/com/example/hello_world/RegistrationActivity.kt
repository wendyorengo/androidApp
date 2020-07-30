package com.example.hello_world

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_registration.view.*

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
            var passwordConfirm = textView5.text.toString()
            var forgotPassword = textViewForgotPassword.text.toString()
    }



    }

}

