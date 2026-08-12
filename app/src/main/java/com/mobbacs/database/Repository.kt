package com.mobbacs.database

import com.mobbacs.database.SupabaseClient.client
import com.mobbacs.models.User
import io.github.jan.supabase.postgrest.from


//comandos para a manipulação do usuario

class UserRepository {

    private val client = SupabaseClient.client

    suspend fun createUser(user: User) {
        client
            .from("tb_usuario")
            .insert(user)
    }

    suspend fun getUser(id: String): User? {
        return client
            .from("tb_usuario")
            .select {
                filter {
                    eq("id_usuario", id)
                }
            }
            .decodeSingleOrNull<User>()
    }

    suspend fun updateUser(user: User) {
        client
            .from("tb_usuario")
            .update(user) {
                filter {
                    eq("id_usuario", user.id_usuario)
                }
            }
    }

    suspend fun deleteUser(id: String) {
        client
            .from("tb_usuario")
            .delete {
                filter {
                    eq("id_usuario", id)
                }
            }
    }
}