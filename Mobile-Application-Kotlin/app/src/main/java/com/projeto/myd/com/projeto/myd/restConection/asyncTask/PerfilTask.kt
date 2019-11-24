package com.projeto.myd.com.projeto.myd.restConection.asyncTask

import android.os.AsyncTask
import com.projeto.myd.com.projeto.myd.model.Usuario
import com.projeto.myd.com.projeto.myd.restConection.Service.EmpresasRequisicoes
import com.projeto.myd.com.projeto.myd.restConection.Service.PerfilRequisicoes
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import java.lang.Exception

class PerfilTask : AsyncTask<String?, Void, Usuario?>() {
    override fun doInBackground(vararg p0: String?): Usuario? {
        val request = Feign.builder()
            .encoder(GsonEncoder())
            .decoder(GsonDecoder())
            .target(PerfilRequisicoes::class.java, "http://10.3.1.253:8080")

        try {
            return request.buscaPerfil(p0[0])
        } catch (e: Exception) {
            println("Requisição Falhou")
            e.printStackTrace()
            return null
        }
    }
}