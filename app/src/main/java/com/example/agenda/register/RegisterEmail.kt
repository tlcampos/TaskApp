package com.example.agenda.register

import androidx.annotation.StringRes

interface RegisterEmail {

    //camada Presenter
    interface Presenter {
        fun registerUser(email: String)
        fun onDestroy()
    }

    interface View {
        fun displayEmailFailure(@StringRes emailError: Int?)
    }
}