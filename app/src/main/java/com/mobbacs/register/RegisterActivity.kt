package com.mobbacs.register
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mobbacs.R
import com.mobbacs.models.User
import com.mobbacs.database.SupabaseClient
import io.github.jan.supabase.auth.auth
import com.mobbacs.database.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterActivity: AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register_conta)

        val userRepository = UserRepository()

        val nome = findViewById<EditText>(R.id.editNome)
        val email = findViewById<EditText>(R.id.editEmail)
        val senha = findViewById<EditText>(R.id.editSenha)
        val cpf = findViewById<EditText>(R.id.editCPF)
        val bntRegister = findViewById<Button>(R.id.bntRegister)

        bntRegister.setOnClickListener {
            val nomeUsuario = nome.text.toString()
            val emailUsuario = email.text.toString()
            val senhaUsuario = senha.text.toString()
            val cpfUsuario = cpf.text.toString()
            val idUsuario = SupabaseClient.client.auth.currentUserOrNull()?.id

            if(nomeUsuario.isEmpty() || emailUsuario.isEmpty() || senhaUsuario.isEmpty() || cpfUsuario.isEmpty())
            {
                Toast.makeText(this, "Escreva vagabundo", Toast.LENGTH_SHORT).show()
            }
            else{
                val usuario = User(
                    cpf = cpfUsuario,
                    email = emailUsuario,
                    nome = nomeUsuario,
                    id_usuario = idUsuario
                )

                lifecycleScope.launch() {
                    try {
                        userRepository.createUser(usuario)
                        Toast.makeText(
                            this@RegisterActivity,
                            "Usuário cadastrado com sucesso!",
                            Toast.LENGTH_LONG
                        ).show()
                    } catch (e: Exception){
                        Toast.makeText(
                            this@RegisterActivity,
                            "Usuário cadastrado com fracasso hahahahahahahah!",
                            Toast.LENGTH_LONG
                        ).show()
                         Log.e("SUPABASE_TESTE", "${e.message}")

                }}




            }
        }

    }

}