interface Testinho{
   var teste: String?

    fun t3stinho(){}

}




open class Calcular(){

    var media: Int = 3
    var soma: Int = 0
    var num3: IntArray? = null

    constructor(num3: IntArray) : this (){
        this.num3
    }

    constructor (media: Int, num3: IntArray): this (){
        this.media = media
        this.num3 = num3
    }



    fun funsoma(): Int {
        for (s in num3!!){
            soma += s
        }
        println("Soma: ${soma}")
        return soma
    }

    fun mul(){
        soma = soma + 1
        for (s in num3!!){
            soma = soma * s
        }
        println("Multiplicação: ${soma}")
        soma = 0
    }

    fun funmedia(){
        for (n in num3!!){
                 soma += n
        }
        println("Media: ${(soma)/ media}")
        soma = 0
    }

    fun fact(num: Int): Int{
        return if(num == 1) num.toInt()
        else num*fact(num-1)
    }
}

 class Calculadora : Calcular, Testinho{

     constructor(num3: IntArray)
     constructor(media: Int, num3: IntArray) : super(media = media, num3 = num3)

     override var teste: String? = null

     override fun t3stinho() {
         println("sla")
         teste = "teste"
         println("Soma + 3: ${ 3 + funsoma()}")
         println(teste)

     }

//    fun teste(){
////        val num: Int
////        num = soma()
//
//    }

}



fun main(){

//    println(media("Funciona karaii", 1f, 2f));

//    println(forzinho(1));

//    println(fact(3));

//    val cal : Calculadora = Calculadora( 2  ,intArrayOf(1,2,3,3))
//
//    println(cal.teste())

//    val array : Array<Int> = arrayOf(2,3,4,5)
//    val lista : List<Int> = listOf(2,5,1,6)
//    val mutlista: MutableList<String> = mutableListOf("sla2", "sla1")
//    val set : Set<Int> = setOf(1,2,3,4)
//    val mutset: MutableSet<String> = mutableSetOf("sla1", "sla2" , "sla3")
//    val map: Map<String, Int> = mapOf("sla1" to 1, Pair("sla2", 2), "sla2" to 3)
//    val mutmap : MutableMap<Int, String> = mutableMapOf(1 to "sl1", Pair(2, "sla2"))
//    println(mutmap)

//    val c: Calcular = Calcular(2,2,2)
//    var num: IntArray = intArrayOf(2,2,2,2,2)
//    val calcular: Calcular = Calcular(media = 2, intArrayOf(2,2,2,2))
    val calculador: Calculadora = Calculadora(media = 2  , num3 = intArrayOf(2, 3 ,4))
    with(calculador){
        funmedia()
        mul()
        funsoma()
        println("teste, ${funsoma()}")
        println(fact(5))
        t3stinho()
    }


}

//fun forzinho(int: Int): Unit{
//    if ( int <= 10){
//        println(int);
//        forzinho(int + 1);
//    }
//}


//fun <K, T> media(abc: T, vararg notas: K): Float{
//
//    var soma = 0f;
//
//    for ( n in notas){
//        if (n is Float){
//            soma += n;
//        }
//        println(notas.size);
//    }
//    println(notas[1]);
//    return (soma / notas.size);
//}
