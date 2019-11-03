package com.projeto.myd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.projeto.myd.com.projeto.myd.Utilities.Criptografia
import com.projeto.myd.com.projeto.myd.model.Usuario
import com.projeto.myd.com.projeto.myd.restConection.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_cadastro.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
    }

    fun cadastrar(v: View){

        val email : String = EditTextCadastroEmail.text.toString();
        val nome : String = EditTextCadastroNome.text.toString();
        val cpf : String = EditTextCadastrocPF.text.toString();
        val senha : String = EditTextCadastroSenha.text.toString();
        val confirmaSenha : String = EditTextCadastroConfimarSenha.text.toString();

        val senhaCriptografada : String = Criptografia.sha256(senha);

        val usuario : Usuario = Usuario(email,senhaCriptografada, cpf, nome, valido = true);

        println(senha.toString());
        println(confirmaSenha.toString())

        if(senha != confirmaSenha){
            Toast.makeText(this, "Senhas são diferentes", Toast.LENGTH_LONG).show()
        }else{
            val call = RetrofitInitializer().cadastroService().cadastrar(usuario);
            call.enqueue(object : Callback<Usuario?> {
                override fun onResponse(call: Call<Usuario?>, response: Response<Usuario?>) {
                    response?.body()?.let {
                        toast("Usuario Cadastrado com sucesso")
                    }
                }

                override fun onFailure(call: Call<Usuario?>, t: Throwable) {
                    toast("Erro ao cadastrar usuario")
                    println("Requisição falhou")
                    Log.e("Erro: ", t?.message)
                }
            })
        }
    }

    fun toast(texto : String){
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }


}
