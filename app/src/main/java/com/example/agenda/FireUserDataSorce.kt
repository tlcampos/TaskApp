package com.example.agenda

import com.example.agenda.common.model.User
import com.google.firebase.firestore.FirebaseFirestore

class FireUserDataSource : UserDataSource {
    override fun fetchUser(userUUID: String, callback: UserCallback<Pair<User, Boolean?>>) {
        FirebaseFirestore.getInstance()
            .collection("/users")
            .document(userUUID)
            .get()
            .addOnSuccessListener { document ->
                val user = document.toObject(User::class.java)
                callback.onSuccess(Pair(user, null))
            }
            .addOnFailureListener { exception ->
                callback.onFailure(exception.message ?: "Erro ao buscar usuário")
            }

    }
}