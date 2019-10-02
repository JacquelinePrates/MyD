package com.projeto.myd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class loginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun irParaHome(v:View){

        var telaHome = Intent(this, homeActivity::class.java)

        startActivity(telaHome)
    }
}