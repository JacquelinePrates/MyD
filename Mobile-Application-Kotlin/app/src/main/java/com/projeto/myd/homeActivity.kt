package com.projeto.myd

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.projeto.myd.com.projeto.myd.model.InformacoesUsuario
import com.projeto.myd.com.projeto.myd.restConection.asyncTask.GruposTask
import com.projeto.myd.fragments.fragmentDashboard
import com.projeto.myd.fragments.fragmentEmpresas
import com.projeto.myd.fragments.fragmentNotificacao
import com.projeto.myd.fragments.fragmentPerfil
import com.projeto.myd.fragments.fragmentGrupos
import com.projeto.myd.fragments.fragmentAgrupador
import kotlinx.android.synthetic.main.fragment_fragment_empresas.*
import kotlinx.android.synthetic.main.fragment_fragment_grupos.*

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

    var informacoesUsuario : InformacoesUsuario? = null

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

                    selecionadorDeUsuario(id)

                    ativo = fragment2
                    return true
                }
                R.id.navigation_notificacao -> {
                    fm.beginTransaction().setCustomAnimations(
                        android.R.animator.fade_in,
                        android.R.animator.fade_out
                    ).hide(ativo).show(fragment3).commit()
                    ativo = fragment3
                    return true
                }
                R.id.navigation_perfil -> {
                    fm.beginTransaction().setCustomAnimations(
                        android.R.animator.fade_in,
                        android.R.animator.fade_out
                    ).hide(ativo).show(fragment4).commit()
                    ativo = fragment4
                    return true
                }
            }
            return false
        }
    }

    fun trocarParaGrupos(v:View) {
        fm.beginTransaction()
            .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
            .hide(ativo).show(fragmentGrupos).commit()

        if(v.id == -1){
            idGruposAtual = 1
        }else if (v.id == 2131230929){
            idGruposAtual = 2
        }

        trocaLogoTopo(idGruposAtual)
        pegaInformacoesDoUsuarioNaquelaEmpresa()

        ativo = fragmentGrupos
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

    public override fun onBackPressed() {
        when (ativo) {
            fragmentGrupos -> retornoParaEmpresa()
            fragmentAgrupador -> retornaParaGrupos()
        }
    }

    fun trocarParaAgrupador(v: View) {
        fm.beginTransaction()
            .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
            .hide(ativo).show(fragmentAgrupador).commit()
        ativo = fragmentAgrupador
    }

    fun selecionadorDeUsuario(id: Long?) {
        if (id == 1L) {

        } else if (id == 2L) {
            segundaEmpresa.visibility = View.GONE
        }
    }

    fun trocaLogoTopo(idGruposAtual: Int?){
        if(idGruposAtual == 2){
            val drawable = resources.getDrawable(R.mipmap.empresaporto)
            iconEmpresa.setImageDrawable(drawable);
        }else if(idGruposAtual == 1){
            val drawable = resources.getDrawable(R.mipmap.empresanubank)
            iconEmpresa.setImageDrawable(drawable);
        }
    }

    fun pegaInformacoesDoUsuarioNaquelaEmpresa(){
        val task = GruposTask()
        informacoesUsuario = task.execute(id.toString(), idGruposAtual.toString()).get()
    }

}