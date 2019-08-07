package entities

class ConsumptionRates{
    private var name: String = ""
    private var start: Int = 0
    private var end: Int = 0
    private var priceRate: Float
    private var numberOfKw: Int = 0

    constructor(name: String,start: Int, end: Int, priceRate: Float){
        this.name = name ;
        this.start = start;
        this.end = end ;
        this.priceRate= priceRate;
        setNumberOfKw()
    }

    private fun setNumberOfKw(){
        this.numberOfKw = this.end - this.start
    }

    fun getRateValue(numberOfKilos: Int): Float{
        return 0.0f ;
    }

}

