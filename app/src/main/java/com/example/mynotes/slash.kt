package com.example.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class slash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slash)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent= Intent(this@slash,MainActivity::class.java)
            startActivity(intent)
            finish()

        },3000)
    }
}