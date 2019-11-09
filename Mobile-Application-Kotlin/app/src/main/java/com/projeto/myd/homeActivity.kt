package com.projeto.myd

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.projeto.myd.fragments.fragmentDashboard
import com.projeto.myd.fragments.fragmentEmpresas
import com.projeto.myd.fragments.fragmentNotificacao
import com.projeto.myd.fragments.fragmentPerfil
import com.projeto.myd.fragments.fragmentGrupos

class homeActivity : AppCompatActivity() {

    val fragment1: Fragment = fragmentDashboard()
    val fragment2: Fragment = fragmentEmpresas()
    val fragment3: Fragment = fragmentNotificacao()
    val fragment4: Fragment = fragmentPerfil()
    val fragmentGrupos: Fragment = fragmentGrupos()
    val fm = supportFragmentManager
    var ativo= fragment1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navigation = findViewById<BottomNavigationView>(R.id.nav_view)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fm.beginTransaction().add(R.id.container, fragment4).hide(fragment4).commit()
        fm.beginTransaction().add(R.id.container, fragment3).hide(fragment3).commit()
        fm.beginTransaction().add(R.id.container, fragment2).hide(fragment2).commit()
        fm.beginTransaction().add(R.id.container, fragmentGrupos).hide(fragmentGrupos).commit()
        fm.beginTransaction().add(R.id.container, fragment1).commit()
    }

    private val mOnNavigationItemSelectedListener = object:
        BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(@NonNull item: MenuItem):Boolean {
            when (item.getItemId()) {
                R.id.navigation_home -> {
                    fm.beginTransaction().hide(ativo).show(fragment1).commit()
                    ativo = fragment1

                    return true
                }
                R.id.navigation_empresas -> {
                    fm.beginTransaction().hide(ativo).show(fragment2).commit()
                    ativo = fragment2
                    return true
                }
                R.id.navigation_notificacao -> {
                    fm.beginTransaction().hide(ativo).show(fragment3).commit()
                    ativo = fragment3
                    return true
                }
                R.id.navigation_perfil -> {
                    fm.beginTransaction().hide(ativo).show(fragment4).commit()
                    ativo = fragment4
                    return true
                }
            }
            return false
        }
    }

    fun trocarParaGrupos(v: View){
         //fm.beginTransaction().replace(R.id.container,fragmentGrupos).commit()
        fm.beginTransaction().hide(ativo).show(fragmentGrupos).commit()
        ativo = fragmentGrupos
    }
}