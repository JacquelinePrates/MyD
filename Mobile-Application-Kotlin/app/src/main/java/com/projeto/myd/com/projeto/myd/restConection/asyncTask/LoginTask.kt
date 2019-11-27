package com.projeto.myd.com.projeto.myd.restConection.asyncTask

import android.os.AsyncTask
import com.projeto.myd.com.projeto.myd.model.Usuario
import com.projeto.myd.com.projeto.myd.restConection.Service.CadastroRequisicoes
import com.projeto.myd.com.projeto.myd.restConection.Service.LoginRequisicoes
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import java.lang.Exception

class LoginTask : AsyncTask<Usuario, Void, Usuario>() {
    override fun doInBackground(vararg params: Usuario?): Usuario? {
        val request = Feign.builder()
            .encoder(GsonEncoder())
            .decoder(GsonDecoder())
            .target(LoginRequisicoes::class.java, "http://10.100.155.225:8080")

        try {
            return request.logar(params[0]!!)
        }catch (e: Exception){
            println("Requisição Falhou")
            e.printStackTrace()
            return null
        }
    }
}