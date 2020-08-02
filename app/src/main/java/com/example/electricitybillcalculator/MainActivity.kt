package com.example.electricitybillcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import entities.Bill
import entities.ConsumptionCategory
import entities.ConsumptionRate
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


            var consumptionCatrogries = this.initializeConsumptionCategories()

            var bill: Bill = Bill(totalConsumedKw,consumptionCatrogries)

            CostViewArea.text =  bill.getPrice()

        }
    }

    private fun initializeConsumptionCategories(): Array<ConsumptionCategory>{
        var firstConsumptionRates: Array<ConsumptionRate> = arrayOf(
            ConsumptionRate("1st",0,50,0.38f,1),
            ConsumptionRate("2nd",51,100,0.48f,2)
        )

        var secondConsumptionRates: Array<ConsumptionRate> = arrayOf(
            ConsumptionRate("3rd",0,200,0.65f,6),
            ConsumptionRate("4th",201,350,0.96f,11),
            ConsumptionRate("5th",351,650,1.18f,15),
            ConsumptionRate("6th",651,1000,1.4f,25)
        )

        var thirdConsumptionRates: Array<ConsumptionRate> = arrayOf(
            ConsumptionRate("7th",0,Int.MAX_VALUE,1.45f,40)
        )
        var firstConsumptioCategory: ConsumptionCategory = ConsumptionCategory(0,100,firstConsumptionRates)
        var secondConsumptioCategory: ConsumptionCategory = ConsumptionCategory(0,999,secondConsumptionRates)
        var thirdConsumptioCategory: ConsumptionCategory = ConsumptionCategory(0,
            Int.MAX_VALUE,thirdConsumptionRates,true)

        var consumptionCatrogries = arrayOf(
            firstConsumptioCategory,
            secondConsumptioCategory,
            thirdConsumptioCategory
        )

        return consumptionCatrogries
    }

}
