package com.projeto.myd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.projeto.myd.com.projeto.myd.Utilities.Criptografia
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

        val senhaDaTela : String = EditTextLoginSenha.text.toString()
        val senhaCriptografada : String = Criptografia.sha256(senhaDaTela)

        usuario.email = EditTextLoginEmail.text.toString()
        usuario.senha = senhaCriptografada

        val call = RetrofitInitializer().loginService().logar(usuario)
        call.enqueue(object : Callback<Usuario?> {
            override fun onResponse(call: Call<Usuario?>, response: Response<Usuario?>) {
                response?.body()?.let {
                    val id = it.id

                    if (it.valido){
                        irParaHome(id)
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

    fun irParaHome(id : Long) {

        var telaHome = Intent(this, homeActivity::class.java)

        telaHome.putExtra("id", id)

        startActivity(telaHome)
    }

    fun cadastro(component:View){

        val cadastro = Intent(this, CadastroActivity:: class.java)

        startActivity(cadastro)
    }
}