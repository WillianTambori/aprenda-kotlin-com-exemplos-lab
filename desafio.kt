// usuário que irá fazer a matricula terá nome e nivel de aprendizagem do curso
// usuário que irá fazer a matricula terá nome e nivel de aprendizagem do curso
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val nivel: Nivel)

// o curso terá disciplinas, a formação terá o papel de informar o nome do curso, disciplinas e inscritos, também a função de matricula do curso
data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    // inscritos com uma lista MutableSet  que tem o papel de não armazenar inscritos repetidos.
    val inscritos: MutableSet<Usuario> = mutableSetOf<Usuario>()
    
    // matricula adiciona o usuario inscrito e informa se o usuário foi matriculado ou não.
    fun matricular(usuario: Usuario) {
        if(inscritos.add(usuario)) print("matriculados no curso $nome") else println("Usuario já matriculado")
        println(inscritos)
    }
}

fun main() {
    var linguagem: MutableList<ConteudoEducacional> = mutableListOf(
        ConteudoEducacional("Python",60),
        ConteudoEducacional("C#",120),
        ConteudoEducacional("Kotlin",80),
    	ConteudoEducacional("Php",90)
        )
    
    var ti: Formacao = Formacao("Analise e desenvolvimento de software",linguagem)
  
    var adm: MutableList<ConteudoEducacional> = mutableListOf(
        ConteudoEducacional("Contabilidade",60),
        ConteudoEducacional("economia",120),
        )

    var administracao: Formacao = Formacao("Administração",adm)
    
    ti.matricular(Usuario("willian",Nivel.DIFICIL))
    ti.matricular(Usuario("willian",Nivel.DIFICIL))// usuário repetido, e não será armazenado pois já foi realizado a sua matricula.
    ti.matricular(Usuario("Rogerio",Nivel.BASICO))
    ti.matricular(Usuario("fabricio",Nivel.INTERMEDIARIO))
    administracao.matricular(Usuario("Melissa",Nivel.DIFICIL))
    administracao.matricular(Usuario("Ronaldo",Nivel.BASICO))
    
           
   
    
}