class Juice() : IType {
    override fun getEffect() {
        println("SO COOL JUICE")
    }
}

class Bar() : IType {
    override fun getEffect() {
        println("SO COOL BAR")
    }

}


class JuiceFactory : IPurchaseFactory {
    override fun createItem(): IType {
        return Juice()
    }
}

class BarFactory : IPurchaseFactory {
    override fun createItem(): IType {
        return Bar()
    }

}

interface IPurchaseFactory {

    fun createItem(): IType
}

interface IType {
    fun getEffect()
}


enum class Avtomat() {
    JUICE {
        override fun createFactory(): IPurchaseFactory {
            return JuiceFactory()
        }
    },
    BAR {
        override fun createFactory(): IPurchaseFactory {
            return BarFactory()
        }
    };

    abstract fun createFactory(): IPurchaseFactory
}


