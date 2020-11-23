package br.com.webservice

import retrofit2.http.GET

interface ApiService {

    @GET("alunos")
    suspend fun getAlunos() : List<Aluno>

    @GET("sort/aluno")
    suspend fun getSortAluno() : Aluno

    @GET("produtos")
    suspend fun getProdutos() : Resultado

}