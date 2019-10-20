package com.projeto.myd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.projeto.myd.com.projeto.myd.model.Usuario
import com.projeto.myd.com.projeto.myd.restConection.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class loginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }

    fun validacaoDeLogin(v: View){

        val usuario : Usuario = Usuario()
        usuario.email = EditTextEmail.text.toString()
        usuario.senha = EditTextSenha.text.toString()

        val call = RetrofitInitializer().loginService().logar(usuario)
        call.enqueue(object : Callback<Usuario?> {
            override fun onResponse(call: Call<Usuario?>, response: Response<Usuario?>) {
                response?.body()?.let {
                    val email = it.email
                    val senha = it.senha
                    println("onResponse")

                    if (it.valido){
                        irParaHome()
                    }else{
                        usuarioInvalido()
                    }

                }
            }

            override fun onFailure(call: Call<Usuario?>, t: Throwable) {
                println("Requisição falhou")
                Log.e("Erro: ", t?.message)
            }
        })
    }

    fun usuarioInvalido(){
        Toast.makeText(this, "Usuario invalido", Toast.LENGTH_LONG).show()
    }

    fun irParaHome(email : String, senha : String) {

        

        var telaHome = Intent(this, homeActivity::class.java)

        startActivity(telaHome)
    }
}