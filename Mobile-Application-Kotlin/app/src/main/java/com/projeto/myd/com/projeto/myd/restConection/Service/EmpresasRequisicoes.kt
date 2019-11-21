package com.projeto.myd.com.projeto.myd.restConection.Service

import com.projeto.myd.com.projeto.myd.model.Empresa
import feign.Headers
import feign.Param
import feign.RequestLine

interface EmpresasRequisicoes {

    @RequestLine("GET empresa/{idEmpresa}/usuario/{idUsuario}")
    @Headers("Accept: application/json",
        "Content-Type: application/json")
    fun listarInformacoesDaEmpresa(@Param("idEmpresa") idEmpresa: String?, @Param("idUsuario") idUsuario:String?) : Empresa

    @RequestLine("GET empresas/todas/usuarios/{idUsuario}")
    @Headers("Accept: application/json",
        "Content-Type: application/json")
    fun listarEmpresasComInformacoa(@Param("idUsuario") idUsuario:Long?) : List<Empresa>
}