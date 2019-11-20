package com.projeto.myd.com.projeto.myd.restConection.asyncTask

import android.os.AsyncTask
import com.projeto.myd.com.projeto.myd.model.InformacoesUsuario
import com.projeto.myd.com.projeto.myd.restConection.Service.CadastroRequisicoes
import com.projeto.myd.com.projeto.myd.restConection.Service.GruposRequisicoes
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import java.lang.Exception

class GruposTask : AsyncTask <String, Void, InformacoesUsuario?>(){
    override fun doInBackground(vararg params: String?): InformacoesUsuario? {
        val request = Feign.builder()
            .encoder(GsonEncoder())
            .decoder(GsonDecoder())
            .target(GruposRequisicoes::class.java, "http://10.3.1.253:8080")

        try {
            return request.listarInformacoesDaEmpresa(params[0], params[1])
        }catch (e: Exception){
            println("Requisição Falhou")
            e.printStackTrace()
            return null
        }
    }

}