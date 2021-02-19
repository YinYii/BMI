package com.example.bmi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bmi.R.layout.calculate


class BMI : AppCompatActivity() {
    var bmiIndex : Double = 0.00
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(calculate)

        val tvname = findViewById<TextView> (R.id.tvname)
        val personName = intent?.getStringExtra("personName")
        tvname.setText(personName)

        if(savedInstanceState != null){
            bmiIndex = savedInstanceState.getDouble("bmi")
            val tvstatus = findViewById<TextView>(R.id.tvstatus)
            tvstatus.setText(getStatus())
        }

        val calbtn = findViewById<Button>(R.id.calbtn)
        
        calbtn.setOnClickListener(){
            val weight = findViewById<TextView>(R.id.weight).text.toString()
            val height = findViewById<TextView>(R.id.height).text.toString()

            bmiIndex = weight.toDouble() / (height.toDouble() * height.toDouble())

            val tvstatus = findViewById<TextView>(R.id.tvstatus)

            tvstatus.setText(getStatus())
        }


        

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmi",bmiIndex)
    }

    fun getStatus():String{
        if(bmiIndex < 18.5)
            return "Underweight"
        else if (bmiIndex <= 24.9)
            return "Normal weight"
        else if (bmiIndex <= 29.9)
            return "Overweight"
        else if (bmiIndex <= 34.9)
            return "Obesity Class I"
        else if (bmiIndex <= 39.9)
            return "Obesity Class II"
        else
            return "Obesity Class III"
        
    }


}