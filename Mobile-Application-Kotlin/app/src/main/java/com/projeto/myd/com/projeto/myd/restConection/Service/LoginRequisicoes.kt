package com.projeto.myd.com.projeto.myd.restConection.Service

import com.projeto.myd.com.projeto.myd.model.Usuario
import feign.Headers
import feign.RequestLine


interface LoginRequisicoes {

    @RequestLine("POST /login")
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    fun logar(usuario : Usuario) : Usuario?
}