package entities

class Bill{
    private var consumption: Int = 0
    private var price: Float = 0.00f
    private var consumptionRates: ConsumptionRates

    constructor(consumption: Int){
        this.consumption = consumption
    }


}