package com.projeto.myd

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.projeto.myd.com.projeto.myd.model.Empresa
import com.projeto.myd.com.projeto.myd.restConection.asyncTask.EmpresaTask
import com.projeto.myd.reciclerView.InformacoesRecyclerAdapter
import kotlinx.android.synthetic.main.activity_visualizar_informacoes.*
import kotlinx.android.synthetic.main.layout_informacoes_list_item.view.*
import java.net.URI

class VisualizarInformacoes : AppCompatActivity() {

    private lateinit var idEmpresa: String
    private var idUsuario: String? = null
    private var empresa: Empresa? = null
    private lateinit var infoAdapter: InformacoesRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_informacoes)
        supportActionBar?.hide()

        val sharedPref: SharedPreferences = getSharedPreferences("myd", 0)

        idUsuario = sharedPref.getString("usuarioId", "undefined")
        idEmpresa = intent.getStringExtra("idEmpresa")

        empresa = pegaInformacoesDoUsuarioNaEmpresa()
        definirLogoDaTela(empresa!!.urlDaLogo)

        initRecyclerView()
    }

    fun pegaInformacoesDoUsuarioNaEmpresa(): Empresa? {
        val task = EmpresaTask()
        return task.execute(idEmpresa, idUsuario).get()
    }

    fun definirLogoDaTela(urlLogo: String) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(this).applyDefaultRequestOptions(requestOptions)
            .load(urlLogo)
            .into(iconEmpresaInfo)
    }

    private fun initRecyclerView(){

        infoRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@VisualizarInformacoes)
            infoAdapter = InformacoesRecyclerAdapter()
            adapter =  infoAdapter
        }

        infoAdapter.submitList(empresa)
    }

    fun editarInformacoes(v:View){

        var chave: String = v.chave.text.toString()
        var empresa: String = v.nomeEmpresa.text.toString()

        var telaEditar = Intent(this, EdicaoInformacoes::class.java)
        telaEditar.putExtra("chave", chave)
        telaEditar.putExtra("empresa", empresa)

        startActivity(telaEditar)
    }
}
