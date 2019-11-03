package com.projeto.myd.com.projeto.myd.restConection

import com.projeto.myd.com.projeto.myd.restConection.Service.CadastroService
import com.projeto.myd.com.projeto.myd.restConection.Service.LoginService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

   private val retrofit =
        Retrofit.Builder()
            .baseUrl("http://192.168.1.5:8080/") // URL do servidor, deve ser trocado pelo IPv4 do seu pc, comando ipconfig no cmd
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun loginService() : LoginService {
        return retrofit.create(LoginService::class.java)
    }

    fun cadastroService() : CadastroService {
        return retrofit.create(CadastroService::class.java)
    }
}
