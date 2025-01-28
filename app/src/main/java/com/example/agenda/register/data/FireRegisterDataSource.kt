package com.example.agenda.register.data

import com.example.agenda.common.model.User
import com.google.firebase.auth.FirebaseAuth
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

    override fun create(email: String, name: String, document: String, password: String, callback: RegisterCallback) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { result ->
                val uid = result.user?.uid
                if (uid == null) {
                    callback.onFailure("Erro interno no servidor.")
                } else {
                    val user = User(uid, email, name, document)
                    FirebaseFirestore.getInstance()
                        .collection("/users")
                        .document(uid)
                        .set(user)
                        .addOnSuccessListener {
                            callback.onSuccess()
                        }
                        .addOnFailureListener { exception ->
                            callback.onFailure(exception.message ?: "Erro interno no servidor.")
                        }
                        .addOnCompleteListener {
                            callback.onComplete()
                        }
                }

            }
            .addOnFailureListener {exception ->
                callback.onFailure(exception.message ?: "Erro interno no servidor.")
            }
    }
}