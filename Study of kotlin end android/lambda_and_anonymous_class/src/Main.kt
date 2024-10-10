interface Cliks {
    fun clickHello()
}

class Form {

    fun clik(e: Cliks){
        e.clickHello()
    }

}

fun main() {

    Form().clik(object: Cliks{
        override fun clickHello() {
            println("Ola")
        }
    })

    val a = { x: Int ->
        x * x
    }

    lambdaA(a)


}

fun lambdaA(sla: (b: Int) -> Int ){
    println(sla(2))

}
