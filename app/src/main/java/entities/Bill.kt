package entities

class Bill{
    private var consumption: Int = 0
    private var calculatedConsumption: Int = 0
    private var price: Float = 0.00f
    private var consumptionCategories: Array<ConsumptionCategory>
    private var remainingConsumptionTillTheNextRate: Int = 0
    private var isInBoundlessRate = false

    constructor(consumption: Int,consumptionCategories: Array<ConsumptionCategory> = emptyArray()){
        this.consumption = consumption
        this.calculatedConsumption = consumption
        this.consumptionCategories = consumptionCategories
    }

    private fun calculatePrice(){
        if(this.price == 0.00f){
            var consumptionRates = this.getConsumptionRates()
            consumptionRates.forEach { System.out.print(it) }

            var lastMiscellaneousCost: Int = 0
            for (consumptionRate in consumptionRates){
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
    }

    private fun getConsumptionRates():Array<ConsumptionRate> {
        var consumptionRates = arrayOf(ConsumptionRate("Empty",0,0,0.0f,0))
        for (consumptionCategory in this.consumptionCategories){
            if(this.consumption < consumptionCategory.getBoundary()){
                consumptionRates = consumptionCategory.getConsumptionRates()
                this.isInBoundlessRate = consumptionCategory.getIsBoundlessFlag()
                break
            }
        }
        return consumptionRates
    }

    fun getPrice(): String{
        this.calculatePrice()
        var priceString: String = "You consumed: "+this.consumption+"kw \n Calculated Price is: "+ this.price
        if(this.remainingConsumptionTillTheNextRate > 0 && !this.isInBoundlessRate){
            priceString += "\nAnd you are "+this.remainingConsumptionTillTheNextRate+" Kws till the next consumption rate"
        }
        return priceString
    }



}