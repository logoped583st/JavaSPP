class SamsungDC() : ITvFunctionality {
    override fun setChannel() {
        println("SET CHANNEL SAMSUNG")
    }

    override fun setVolume() {
        println("SET VOLUME SAMSUNG")
    }

}

class LGDC() : ITvFunctionality {
    override fun setChannel() {
        println("SET CHANNEL LG")
    }

    override fun setVolume() {
        println("SET VOLUME LG")
    }

}

abstract class BaseTv(val iTvFunctionality: ITvFunctionality) {
    abstract fun testFunctions()

    abstract fun colorSchem()
}

class TvSamsung : BaseTv(SamsungDC()) {
    override fun colorSchem() {
        println("FINE COLOR SCHEME")
    }

    override fun testFunctions() {
        iTvFunctionality.setChannel()
        iTvFunctionality.setVolume()
    }
}


interface ITvFunctionality {
    fun setVolume()
    fun setChannel()
}