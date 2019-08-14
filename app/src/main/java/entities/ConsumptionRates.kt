package entities

class ConsumptionRate{
    private var name: String = ""
    private var start: Int = 0
    private var end: Int = 0
    private var priceRate: Float
    private var numberOfKw: Int = 0
    private var miscellaneousCost: Int = 0

    constructor(name: String,start: Int, end: Int, priceRate: Float,miscellaneousCost: Int){
        this.name = name ;
        this.start = start;
        this.end = end ;
        this.priceRate= priceRate;
        this.miscellaneousCost= miscellaneousCost;
        setNumberOfKw()
    }

    private fun setNumberOfKw(){
        this.numberOfKw = this.end - this.start
    }

    fun getPriceRate(): Float{
        return this.priceRate
    }

    fun getNumberOfKw(): Int{
        return this.numberOfKw
    }

    fun getMiscellaneousCost(): Int{
        return this.miscellaneousCost
    }

}

