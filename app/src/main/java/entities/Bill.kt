package entities

class Bill{
    private var consumption: Int = 0
    private var calculatedConsumption: Int = 0
    private var price: Float = 0.00f
    private var consumptionRates: Array<ConsumptionRate>
    private var consumptionCategories: Array<ConsumptionCategory>
    private var remainingConsumptionTillTheNextRate: Int = 0

    constructor(consumption: Int,consumptionRates: Array<ConsumptionRate>,consumptionCategories: Array<ConsumptionCategory>){
        this.consumption = consumption
        this.calculatedConsumption = consumption
        this.consumptionRates = consumptionRates
        this.consumptionCategories = consumptionCategories
    }

    fun calculatePrice(){
        var lastMiscellaneousCost: Int = 0
        for (consumptionRate in this.consumptionRates){
            var consumedKw: Int = 0
            if(this.calculatedConsumption > 0){
                if(this.calculatedConsumption > consumptionRate.getNumberOfKw()){
                    consumedKw = consumptionRate.getNumberOfKw()
                }else{
                    consumedKw = this.calculatedConsumption
                    this.remainingConsumptionTillTheNextRate = consumptionRate.getNumberOfKw() - consumedKw
                }
                var tempCost:Float = consumptionRate.getPriceRate() * consumedKw
                this.price += tempCost
                this.calculatedConsumption -= consumedKw
                lastMiscellaneousCost = consumptionRate.getMiscellaneousCost()
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