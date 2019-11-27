package com.projeto.myd.com.projeto.myd.restConection.Service

import com.projeto.myd.com.projeto.myd.model.Usuario
import feign.Body
import feign.Headers
import feign.Param
import feign.RequestLine

interface CadastroRequisicoes {

    @RequestLine("POST /cadastro")
    @Headers("Accept: application/json",
        "Content-Type: application/json")
    fun cadastrar(usuario: Usuario) : Usuario?

    @RequestLine("POST /cadastro/atualizar")
    @Headers("Accept: application/json",
        "Content-Type: application/json")
    fun atualizar(usuario: Usuario) : Usuario?
}