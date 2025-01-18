package com.example.agenda.register

import androidx.annotation.StringRes

interface RegisterEmail {

    //camada Presenter
    interface Presenter {
        fun create(email: String)
        fun onDestroy()
    }

    interface View {
        fun showProgress(enabled: Boolean)

        fun displayEmailFailure(@StringRes emailError: Int?)

        fun onEmailFailure(message: String)

        fun goToNameAndPasswordScreen(email: String)
    }
}