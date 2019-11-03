package com.projeto.myd.com.projeto.myd.restConection

import com.projeto.myd.com.projeto.myd.restConection.Service.LoginService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

   private val retrofit =
        Retrofit.Builder()
            .baseUrl("http://10.3.1.253:8080") // URL do servidor, deve ser trocado pelo IPv4 do seu pc, comando ipconfig no cmd
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun loginService() : LoginService {
        return retrofit.create(LoginService::class.java)
    }
}
