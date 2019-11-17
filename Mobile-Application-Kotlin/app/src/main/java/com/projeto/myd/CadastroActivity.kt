package com.projeto.myd

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.projeto.myd.com.projeto.myd.Utilities.Criptografia
import com.projeto.myd.com.projeto.myd.model.Usuario
import com.projeto.myd.com.projeto.myd.restConection.asyncTask.CadastroTask
import kotlinx.android.synthetic.main.activity_cadastro.*
import java.util.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun cadastrar(v: View){

        val email : String = EditTextCadastroEmail.text.toString();
        val nome : String = EditTextCadastroNome.text.toString();
        val cpf : String = EditTextCadastrocPF.text.toString();
        val senha : String = EditTextCadastroSenha.text.toString();
        val confirmaSenha : String = EditTextCadastroConfimarSenha.text.toString();

        val senhaCriptografada : String = Criptografia.sha256(senha);

        val usuario : Usuario = Usuario(-1, email,senhaCriptografada, cpf, nome, valido = true);

        if(senha != confirmaSenha){
            Toast.makeText(this, "Senhas são diferentes", Toast.LENGTH_LONG).show()
        }else{
            val task = CadastroTask()
            val usuarioRetorno : Usuario? = task.execute(usuario).get()
            if(Objects.nonNull(usuarioRetorno)){
                toast("Cadastrado")
            }else{
                toast("Erro ao cadastrar")
            }
        }
    }

    fun toast(texto : String){
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }

    fun irParaLogin(component:View){

        val login = Intent(this, loginActivity:: class.java)

        startActivity(login)
    }


}
