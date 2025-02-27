package com.example.agenda.login.data

import com.google.firebase.auth.FirebaseAuth

class FireLoginDataSource : LoginDataSource {
    override fun login(email: String, password: String, callback: LoginCallback) {
        val auth = FirebaseAuth.getInstance()

        auth.signInWithEmailAndPassword(email, password)

            .addOnSuccessListener { res ->
                if (res.user != null) {
                    callback.onSuccess()
                } else {
                    callback.onFailure("Usuário não encontrado")
                }
            }
            .addOnFailureListener { exception ->
                callback.onFailure(exception.message ?: "Erro ao fazer login.")

            }
            .addOnCompleteListener {
                callback.onComplete()
            }

    }

}