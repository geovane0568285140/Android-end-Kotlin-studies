package control

import business.ConvidadoBusiness
import entity.Convidado

class Portaria {

    private val convidadoBusiness = ConvidadoBusiness()

    init {
        println("Portaria initialization!")
        println(controle())
    }

    fun controle(): String{
        val idade = Console.readInt("Qual sua Idade? ");
        println(idade)
        val convidado = Convidado(idade = idade)
        if (convidadoBusiness.maiorDeIdade(convidado.idade)){
            return "Negado. Menores de idade não são permitidos!"
        }

        convidado.tipo = Console.readString("Qual seu tipo de convite?")
        if (!convidadoBusiness.tipoValida(convidado.tipo)){
            return "Negado. Convite invalido"
        }

        /*
        if (!conviteBusiness.codigoValido(codigo, tipoConvite)){
            return "Negado. Convite invalido"
        }

        */

        convidado.codigo = Console.readString("Qual seu codigo de convite?")
        if (!convidadoBusiness.codigoValida(convidado)){
            return "Negado. Convite invalido"
        }



        return "welcome :)"
    }


}

/*
fun portaria() {
    print("Qual sua idade? ")
    val idade = readLine()

    if (idade != null && idade != "") {
        if (idade.toInt() < 18) {
            println("Negado. Menores de idade não são permitidos.")
            return
        }
    }

    print("Qual é o tipo de convite? ")
    var tipoConvite = readLine()

    if (tipoConvite != null && tipoConvite != "") {
        tipoConvite = tipoConvite.lowercase()

        // Validação do tipo de convite
        if (tipoConvite != "comum" && tipoConvite != "premium" && tipoConvite != "luxo") {
            println("Negado. entity.Convite inválido.")
            return
        }

        print("Qual o código do convite? ")
        var codigo = readLine()

        if (codigo != null && codigo != "") {
            codigo = codigo.lowercase()

            if (tipoConvite == "comum" && codigo.startsWith("xt")) {
                println("Welcome :)")
            } else if ((tipoConvite == "premium" || tipoConvite == "luxo") && codigo.startsWith("xl")
            ) {
                println("Welcome :)")
            } else {
                println("Negado. entity.Convite inválido")
            }
        }
    }
}
* */