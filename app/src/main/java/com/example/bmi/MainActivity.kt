package com.example.bmi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterbtn: Button = findViewById(R.id.enterbtn)

        enterbtn.setOnClickListener(){
            val name = findViewById<TextView> (R.id.name)

            val intent = Intent(this, BMI::class.java)

            intent.putExtra("personName", name.text.toString())
            startActivity(intent)
        }

    }


}


