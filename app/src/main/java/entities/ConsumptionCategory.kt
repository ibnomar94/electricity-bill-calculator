package entities

class ConsumptionCategory {
    private var consumptionRates: Array<ConsumptionRate>
    private var startOfCategory:Int = 0
    private var endOfCategory:Int = 0
    private var isBoundless: Boolean = false

    constructor(startOfCategory: Int,endOfCategory: Int,consumptionRates: Array<ConsumptionRate>,isBoundless: Boolean = false){
        this.startOfCategory = startOfCategory
        this.endOfCategory = endOfCategory
        this.consumptionRates = consumptionRates
        this.isBoundless = isBoundless
    }
}