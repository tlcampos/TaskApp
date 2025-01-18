package com.example.agenda.login.data

import android.os.Handler
import android.os.Looper
import com.example.agenda.common.model.Database

class FakeDataSource : LoginDataSource {
    override fun login(email: String, password: String, callback: LoginCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.userAuth.firstOrNull { email == it.email }

            when {
                userAuth == null -> {
                    callback.onFailure("Usuário não encontrado")
                }

                userAuth.password != password -> {
                    callback.onFailure("Senha incorreta")
                }

                else -> {
                    Database.sessionAuth = userAuth
                    callback.onSuccess(userAuth)

                }
            }
            callback.onComplete()
        }, 2000)
    }
}
