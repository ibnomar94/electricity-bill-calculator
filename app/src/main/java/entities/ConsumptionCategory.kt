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

    fun getBoundary(): Int{
        return this.endOfCategory
    }

    fun getConsumptionRates(): Array<ConsumptionRate>{
        return this.consumptionRates
    }

    fun getIsBoundlessFlag(): Boolean{
        return this.isBoundless
    }
}