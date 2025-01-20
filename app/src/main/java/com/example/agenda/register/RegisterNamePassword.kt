package com.example.agenda.register

import androidx.annotation.StringRes

interface RegisterNamePassword {
    //camada Presenter
    interface Presenter {
        fun create(email: String,document: String, name: String, password: String, confirmPassword: String)
        fun onDestroy()
    }

    interface View {
        fun showProgress(enabled: Boolean)

        fun displayNameFailure(@StringRes nameError: Int?)

        fun displayPasswordFailure(@StringRes passError: Int?)

        fun displayDocumentFailure(@StringRes docError: Int?)

        fun onCreateFailure(message: String)

        fun onCreateSuccess(name: String)

    }
}
