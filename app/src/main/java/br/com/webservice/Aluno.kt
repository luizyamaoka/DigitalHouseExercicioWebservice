package br.com.webservice

class Aluno(val id: Int, val nome: String, val email: String, val qtd_star: Int) {
    override fun toString(): String {
        return "Aluno(id=$id, nome='$nome', email='$email', qtd_star=$qtd_star)"
    }
}