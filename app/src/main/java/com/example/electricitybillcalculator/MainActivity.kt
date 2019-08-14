package com.example.electricitybillcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import entities.Bill
import entities.ConsumptionRates
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

            var totalConsumedKw: Int = intCurrentConsumption - intPreviousConsumption


            var consumptionRates: Array<ConsumptionRates> = arrayOf(
                    ConsumptionRates("One",0,200,0.5f,6),
                    ConsumptionRates("Two",201,350,0.82f,11),
                    ConsumptionRates("Three",351,650,1.0f,15),
                    ConsumptionRates("Fourth",651,1000,1.4f,25)
                    )



            var bill: Bill = Bill(totalConsumedKw,consumptionRates)
            bill.calculatePrice()
            CostViewArea.text =  bill.getPrice()

        }
    }

}
