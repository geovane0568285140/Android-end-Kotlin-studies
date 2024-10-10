package business
import entity.Convidado

class ConvidadoBusiness {

    fun tipoValida(tipo: String) = (tipo == "comum" || tipo == "premium" || tipo == "luxo")



    fun maiorDeIdade(idade: Int) = idade < 18


    /* fun codigoValido(codigo: String, tipo: String): Boolean{

            if (tipo == "comum" && codigo.startsWith("xt")) {
                return true
            } else if ((tipo == "premium" || tipo == "luxo") && codigo.startsWith("xl")
            ) {
                return true
            } else {
                return false
            }
        } */

    fun codigoValida(convite: Convidado) = when (convite.tipo){
             "comum" -> convite.codigo.startsWith("xt")
             "premium", "luxo" -> convite.codigo.startsWith("xl")
             else -> false
         }



}

