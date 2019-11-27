package com.projeto.myd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edicao_informacoes.*

class EdicaoInformacoes : AppCompatActivity() {

    lateinit var chave:String
    lateinit var valor:String
    lateinit var empresa:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edicao_informacoes)
        supportActionBar?.hide()

        chave = intent.getStringExtra("chave")
        empresa = intent.getStringExtra("empresa")

        textoTitulo.text = "Edição ${chave}"
    }

    fun excluir(v: View){
        var texto = "Notificamos a empresa ${empresa} que sua informação, ${chave}, Deve ser excluida"
        VariavelGlobal.notificacoes.add(texto)
        toast("Requisição de exclusão enviada")
    }

    fun editar(v: View){
        var texto = "Notificamos a empresa ${empresa} que sua informação, ${chave}, Deve ser atualizada para ${valorNovo.text}"
        VariavelGlobal.notificacoes.add(texto)
        toast("Requisição de edição enviada")
    }

    fun toast(texto : String){
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }
}
