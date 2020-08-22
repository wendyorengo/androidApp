package com.example.hello_world

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val SharedPreferenes = PreferenceManager.getDefaultSharedPreferences(baseContext)
        var accessToken = SharedPreferenes.getString("ACESS_TOKEN_KEY","")

        if(accessToken.isNullOrEmpty()){
            val intent = Intent(baseContext,RegistrationActivity::class.java)
            startActivity(intent)
        } else{
            val intent = Intent(baseContext, CourseActivity::class.java)
            startActivity(intent)
        }
    }
}