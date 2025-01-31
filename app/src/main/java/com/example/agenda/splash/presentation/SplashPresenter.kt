package com.example.agenda.splash.presentation

import com.example.agenda.splash.data.SplashCallback
import com.example.agenda.splash.data.SplashRepository
import com.example.agenda.splash.Splash

class SplashPresenter(
    private var view: Splash.View?,
    private val repository: SplashRepository
) : Splash.Presenter {

    override fun authenticated() {
        repository.session(object : SplashCallback {
            override fun onSuccess() {
                view?.goToMainScreen()
            }
            override fun onFailure() {
                view?.goToLoginScreen()
            }
        })
    }

    override fun onDestroy() {

    }
}