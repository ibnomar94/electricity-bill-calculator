package entities

class ConsumptionRates{
    private var name: String = ""
    private var start: Int = 0
    private var end: Int = 0
    var priceRate: Float
    var numberOfKw: Int = 0
    var miscellaneousCost: Int = 0

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

}

