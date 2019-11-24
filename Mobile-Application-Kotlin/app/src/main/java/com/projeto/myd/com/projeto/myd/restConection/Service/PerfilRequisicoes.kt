package com.projeto.myd.com.projeto.myd.restConection.Service

import com.projeto.myd.com.projeto.myd.model.Usuario
import feign.Headers
import feign.Param
import feign.RequestLine

interface PerfilRequisicoes {

    @RequestLine("GET /cadastro/buscar/{id}")
    @Headers("Accept: application/json",
        "Content-Type: application/json")
    fun buscaPerfil(@Param("id")id:String?): Usuario?
}