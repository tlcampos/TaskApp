package com.example.agenda.register.data

import com.google.firebase.firestore.FirebaseFirestore

class FireRegisterDataSource : RegisterDataSource {
    override fun create(email: String, callback: RegisterCallback) {
        FirebaseFirestore.getInstance()
            .collection("/users")
            .whereEqualTo("email", email)
            .get()
            .addOnSuccessListener { documents ->
                if(documents.isEmpty){
                    callback.onSuccess()
                } else {
                    callback.onFailure("Usuário já cadastrado")
                }
            }
            .addOnFailureListener { exception ->
                callback.onFailure(exception.message ?: "Erro interno no servidor.")
            }
            .addOnCompleteListener {
                callback.onComplete()
            }
    }

    override fun create(
        email: String,
        name: String,
        document: String,
        password: String,
        callback: RegisterCallback
    ) {
        TODO("Not yet implemented")
    }
}