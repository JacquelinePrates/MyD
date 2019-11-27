package com.projeto.myd.com.projeto.myd.restConection.asyncTask

import android.os.AsyncTask
import com.projeto.myd.VariavelGlobal
import com.projeto.myd.com.projeto.myd.model.Usuario
import com.projeto.myd.com.projeto.myd.restConection.Service.CadastroRequisicoes
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import java.lang.Exception

class CadastroTask : AsyncTask<Usuario, Void, Usuario>(){
    override fun doInBackground(vararg params: Usuario?): Usuario? {
        val request = Feign.builder()
            .encoder(GsonEncoder())
            .decoder(GsonDecoder())
            .target(CadastroRequisicoes::class.java, (VariavelGlobal.urlDoPc+":8080"))

        try {
            return request.cadastrar(params[0]!!)
        }catch (e:Exception){
            println("Requisição Falhou")
            e.printStackTrace()
            return null
        }
    }
}

