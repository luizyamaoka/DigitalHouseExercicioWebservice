package br.com.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://promoios.com.br/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun apiService() = retrofit.create(ApiService::class.java)

}