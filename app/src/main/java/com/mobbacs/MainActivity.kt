package com.mobbacs

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.mobbacs.database.UserRepository
import com.mobbacs.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val userRepository = UserRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val user = User(
            cpf = "564",
            email = "joao@email.com",
            id_usuario = 1,
            nome = "João",
            senha = "1234"

        )

        // Execute background tasks safely using Coroutines
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                userRepository.createUser(user)
                Log.d("SUPABASE_TESTE", "Usuário criado com sucesso!")
            } catch (e: Exception) {
                Log.e("SUPABASE_TESTE", "Erro ao criar usuário: ${e.message}", e)
            }
        }
    }
}