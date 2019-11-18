package com.projeto.myd

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.projeto.myd.com.projeto.myd.model.Empresa
import com.projeto.myd.com.projeto.myd.restConection.asyncTask.EmpresaTask
import com.projeto.myd.com.projeto.myd.restConection.asyncTask.TodasEmpresasTask
import com.projeto.myd.fragments.fragmentDashboard
import com.projeto.myd.fragments.fragmentEmpresas
import com.projeto.myd.fragments.fragmentNotificacao
import com.projeto.myd.fragments.fragmentPerfil
import com.projeto.myd.fragments.fragmentGrupos
import com.projeto.myd.fragments.fragmentAgrupador

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

}