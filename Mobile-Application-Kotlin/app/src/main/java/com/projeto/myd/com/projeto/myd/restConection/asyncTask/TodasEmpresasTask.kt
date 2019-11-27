package com.projeto.myd.com.projeto.myd.restConection.asyncTask

import android.os.AsyncTask
import com.projeto.myd.com.projeto.myd.model.Empresa
import com.projeto.myd.com.projeto.myd.restConection.Service.EmpresasRequisicoes
import com.projeto.myd.fragments.fragmentEmpresas
import com.projeto.myd.homeActivity
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import java.lang.Exception

class TodasEmpresasTask : AsyncTask<Long?, Void, List<Empresa>?>(){
    override fun doInBackground(vararg params: Long?): List<Empresa>? {
        val request = Feign.builder()
            .encoder(GsonEncoder())
            .decoder(GsonDecoder())
            .target(EmpresasRequisicoes::class.java, "http://10.100.155.225:8080")

        try {
            return request.listarEmpresasComInformacoa(params[0])
        }catch (e: Exception){
            println("Requisição Falhou")
            e.printStackTrace()
            return null
        }
    }

}