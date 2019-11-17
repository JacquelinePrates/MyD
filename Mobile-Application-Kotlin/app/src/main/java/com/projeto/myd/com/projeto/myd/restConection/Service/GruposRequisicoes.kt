package com.projeto.myd.com.projeto.myd.restConection.Service

import com.projeto.myd.com.projeto.myd.model.InformacoesUsuario
import feign.Headers
import feign.Param
import feign.RequestLine

interface GruposRequisicoes {

    @RequestLine("GET empresa/{idEmpresa}/usuario/{idUsuario}")
    @Headers("Accept: application/json",
        "Content-Type: application/json")
    fun listarInformacoesDaEmpresa(@Param("idEmpresa") idEmpresa: String?, @Param("idUsuario") idUsuario:String?) : InformacoesUsuario
}