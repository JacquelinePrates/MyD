package com.projeto.myd

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.projeto.myd.com.projeto.myd.Utilities.Criptografia
import com.projeto.myd.com.projeto.myd.model.Empresa
import com.projeto.myd.com.projeto.myd.model.Usuario
import com.projeto.myd.com.projeto.myd.restConection.asyncTask.*
import com.projeto.myd.fragments.fragmentDashboard
import com.projeto.myd.fragments.fragmentEmpresas
import com.projeto.myd.fragments.fragmentNotificacao
import com.projeto.myd.fragments.fragmentPerfil
import com.projeto.myd.fragments.fragmentGrupos
import com.projeto.myd.fragments.fragmentAgrupador
import com.projeto.myd.reciclerView.EmpresaRecyclerAdapter
import com.projeto.myd.reciclerView.NotificacaoRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_fragment_empresas.*
import kotlinx.android.synthetic.main.fragment_fragment_perfil.*
import kotlinx.android.synthetic.main.fragment_fragment_notificacao.*
import kotlinx.android.synthetic.main.layout_empresas_list_item.view.*
import java.util.*

class homeActivity : AppCompatActivity() {

    val fragment1: Fragment = fragmentDashboard()
    val fragment2: Fragment = fragmentEmpresas()
    val fragment3: Fragment = fragmentNotificacao()
    val fragment4: Fragment = fragmentPerfil()
    val fragmentGrupos: Fragment = fragmentGrupos()
    val fragmentAgrupador: Fragment = fragmentAgrupador()
    val fm = supportFragmentManager
    var ativo = fragment1

    var id: Long? = null
    var idGruposAtual: Int? = null
    var empresasComInformacao : List<Empresa>? = null
    private lateinit var empresaAdater : EmpresaRecyclerAdapter

    var usuarioPerfil: Usuario? = null
    var usuarioId: String? = null

    private lateinit var notificacaoAdapter : NotificacaoRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navigation = findViewById<BottomNavigationView>(R.id.nav_view)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fm.beginTransaction().add(R.id.container, fragment4).hide(fragment4).commit()
        fm.beginTransaction().add(R.id.container, fragment3).hide(fragment3).commit()
        fm.beginTransaction().add(R.id.container, fragment2).hide(fragment2).commit()
        fm.beginTransaction().add(R.id.container, fragmentGrupos).hide(fragmentGrupos).commit()
        fm.beginTransaction().add(R.id.container, fragmentAgrupador).hide(fragmentAgrupador)
            .commit()
        val commit = fm.beginTransaction().add(R.id.container, fragment1).commit()

        id = intent.getLongExtra("id", 0)

        val sharedPref: SharedPreferences = getSharedPreferences("myd", 0)
        val editor = sharedPref.edit()
        editor.putString("usuarioId", id.toString())
        editor.apply()

        empresasComInformacao = pegaEmpresasComInformacao(id)
    }

    private val mOnNavigationItemSelectedListener = object :
        BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.getItemId()) {
                R.id.navigation_home -> {
                    fm.beginTransaction().setCustomAnimations(
                        android.R.animator.fade_in,
                        android.R.animator.fade_out
                    ).hide(ativo).show(fragment1).commit()
                    ativo = fragment1

                    return true
                }
                R.id.navigation_empresas -> {
                    fm.beginTransaction().setCustomAnimations(
                        android.R.animator.fade_in,
                        android.R.animator.fade_out
                    ).hide(ativo).show(fragment2).commit()

                    initRecyclerView()
                    addDataSet()
                    ativo = fragment2
                    return true
                }
                R.id.navigation_notificacao -> {
                    fm.beginTransaction().setCustomAnimations(
                        android.R.animator.fade_in,
                        android.R.animator.fade_out
                    ).hide(ativo).show(fragment3).commit()

                    initRecyclerViewNotificacao()

                    ativo = fragment3
                    return true
                }
                R.id.navigation_perfil -> {
                    fm.beginTransaction().setCustomAnimations(
                        android.R.animator.fade_in,
                        android.R.animator.fade_out
                    ).hide(ativo).show(fragment4).commit()

                    val sharedPref: SharedPreferences = getSharedPreferences("myd", 0)
                    usuarioId = sharedPref.getString("usuarioId", "undefined")

                    usuarioPerfil = pegaPerfil(usuarioId)

                    editText5.setText(usuarioPerfil!!.email)
                    editText.setText(usuarioPerfil!!.nome)
                    editText2.setText(usuarioPerfil!!.cpf)

                    ativo = fragment4
                    return true
                }
            }
            return false
        }
    }

    fun initRecyclerViewNotificacao(){
        notificacaoReciclerView.layoutManager = LinearLayoutManager(this@homeActivity)
        notificacaoAdapter = NotificacaoRecyclerAdapter()
        notificacaoReciclerView.adapter = notificacaoAdapter

        notificacaoAdapter.submitList(VariavelGlobal.notificacoes)
    }

    fun initRecyclerView(){
        recycler_view.layoutManager = LinearLayoutManager(this@homeActivity)
        empresaAdater = EmpresaRecyclerAdapter()
        recycler_view.adapter = empresaAdater
    }

    fun addDataSet(){
        val data = empresasComInformacao
        empresaAdater.submitList(data!!)
    }

    fun clickEmpresaRecliclerView(v: View){
        val id = v.findViewById<TextView>(R.id.empresa_id)
        val telaInformacoes = Intent(this, VisualizarInformacoes::class.java)
        telaInformacoes.putExtra("idEmpresa", id.text)
        startActivity(telaInformacoes)
    }

    fun retornoParaEmpresa(v: View) {
        fm.beginTransaction()
            .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
            .hide(ativo).show(fragment2).commit()
        ativo = fragment2
    }

    fun retornoParaEmpresa() {
        fm.beginTransaction()
            .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
            .hide(ativo).show(fragment2).commit()
        ativo = fragment2
    }

    fun retornaParaGrupos() {
        fm.beginTransaction()
            .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
            .hide(ativo).show(fragmentGrupos).commit()
        ativo = fragmentGrupos
    }

    override fun onBackPressed() {
        when (ativo) {
            fragmentGrupos -> retornoParaEmpresa()
            fragmentAgrupador -> retornaParaGrupos()
            fragment1, fragment2, fragment3, fragment4 -> finish()
        }
    }

    fun trocarParaAgrupador(v: View) {
        fm.beginTransaction()
            .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
            .hide(ativo).show(fragmentAgrupador).commit()
        ativo = fragmentAgrupador
    }

    fun pegaEmpresasComInformacao(usuarioId : Long?): List<Empresa>?{
        val task = TodasEmpresasTask()
        return task.execute(usuarioId).get()
    }

    fun pegaPerfil(id:String?): Usuario? {
        val task = PerfilTask()
        return task.execute(id).get()
    }

    fun mandaPerfil(v:View) {
        val usuario = Usuario()
        usuario.email = editText5.text.toString()
        usuario.nome = editText.text.toString()

        if(editText3.text.toString() != "senha"){
            usuario.senha = Criptografia.sha256(editText3.text.toString())
        }

        usuario.cpf =  editText2.text.toString()

        val task = CadastroAtualizarTask()
        val fodase = task.execute(usuario).get()
    }
}