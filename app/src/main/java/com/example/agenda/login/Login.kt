package com.example.agenda.login

import androidx.annotation.StringRes

interface Login {
    //camada Presenter
    interface Presenter {
        fun login(email: String, password: String)

        fun onDestroy()
    }


    //camada view
    interface View {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int?)
        fun displayPasswordFailure(@StringRes passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message: String)
    }
}