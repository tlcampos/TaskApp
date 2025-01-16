package com.example.agenda.login

interface Login {
    //camada Presenter
    interface Presenter {
        fun login(email: String, password: String)

        fun onDestroy()
    }


    //camada view
    interface View {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(emailError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message: String)
    }
}