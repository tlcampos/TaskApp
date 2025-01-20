package com.example.agenda.register.data

import android.os.Handler
import android.os.Looper
import com.example.agenda.common.model.Database
import com.example.agenda.common.model.UserAuth
import java.util.UUID

class FakeRegisterDataSource : RegisterDataSource {

    override fun create(email: String, callback: RegisterCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.userAuth.firstOrNull { email == it.email }

            if (userAuth == null) {
                callback.onSuccess()
            } else {
                callback.onFailure("Usuário já cadastrado")
            }

            callback.onComplete()
        }, 1000)
    }

    override fun create(
        email: String,
        name: String,
        document: String,
        password: String,
        callback: RegisterCallback
    ) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.userAuth.firstOrNull { email == it.email }

            if (userAuth != null) {
            callback.onFailure("Usuário já cadastrado")
            } else {

                val created = Database.userAuth.add(
                    UserAuth(UUID.randomUUID().toString(), email, name, document, password)
                )
                if (created) {
                    callback.onSuccess()
                } else {
                    callback.onFailure("Erro interno no servidor.")
                }
            }

            callback.onComplete()
        }, 1000)
    }
}
