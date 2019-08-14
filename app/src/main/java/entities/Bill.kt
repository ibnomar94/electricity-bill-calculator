package entities

class Bill{
    private var consumption: Int = 0
    private var calculatedConsumption: Int = 0
    private var price: Float = 0.00f
    private var consumptionRates: Array<ConsumptionRates>
    private var remainingConsumptionTillTheNextRate: Int = 0

    constructor(consumption: Int,consumptionRates: Array<ConsumptionRates>){
        this.consumption = consumption
        this.calculatedConsumption = consumption
        this.consumptionRates = consumptionRates
    }

    fun calculatePrice(){
        var lastMiscellaneousCost: Int = 0
        for (consumptionRate in this.consumptionRates){
            var consumedKw: Int = 0
            if(this.calculatedConsumption > 0){
                if(this.calculatedConsumption > consumptionRate.numberOfKw){
                    consumedKw = consumptionRate.numberOfKw
                }else{
                    consumedKw = this.calculatedConsumption
                    this.remainingConsumptionTillTheNextRate = consumptionRate.numberOfKw - consumedKw
                }
                var tempCost:Float = consumptionRate.priceRate * consumedKw
                this.price += tempCost
                this.calculatedConsumption -= consumedKw
                lastMiscellaneousCost = consumptionRate.miscellaneousCost
            }
        }

        this.price += lastMiscellaneousCost
    }

    fun getPrice(): String{
        var priceString: String = "Calculated Price is: "+ this.price
        if(this.remainingConsumptionTillTheNextRate > 0){
            priceString += "\nAnd you are "+this.remainingConsumptionTillTheNextRate+" Kws till the next consumption rate"
        }
        return priceString
    }


}