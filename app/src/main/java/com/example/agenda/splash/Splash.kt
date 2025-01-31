package com.example.agenda.splash

interface Splash {

    interface Presenter {
        fun authenticated()

        fun onDestroy()
    }

    interface View {
        fun goToMainScreen()
        fun goToLoginScreen()
    }
}