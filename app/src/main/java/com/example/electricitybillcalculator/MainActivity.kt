package com.example.electricitybillcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculateBillBtn.setOnClickListener(){
            var previousConsumption = previousConsumption.text.toString()
            var intPreviousConsumption = previousConsumption.toInt()
            var currentConsumption = currentConsumption.text.toString()
            var intCurrentConsumption = currentConsumption.toInt()
            println(previousConsumption)
            println(currentConsumption)
        }

    }
}
