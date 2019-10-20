package com.projeto.myd.com.projeto.myd.restConection.Service

import com.projeto.myd.com.projeto.myd.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginService {

    @POST("login")
    fun logar(@Body usuario: Usuario) : Call<Usuario>
}