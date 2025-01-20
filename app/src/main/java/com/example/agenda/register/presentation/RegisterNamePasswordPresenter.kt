package com.example.agenda.register.presentation

import com.example.agenda.R
import com.example.agenda.register.RegisterNamePassword
import com.example.agenda.register.data.RegisterCallback
import com.example.agenda.register.data.RegisterRepository

class RegisterNamePasswordPresenter(
    private var view: RegisterNamePassword.View?,
    private val repository: RegisterRepository
) : RegisterNamePassword.Presenter {

    override fun create(email: String, document: String, name: String, password: String, confirmPassword: String) {
        val isNameValid = name.length > 3
        val isDocumentValid = document.length == 11
        val isPasswordValid = password.length >= 8
        val isConfirmValid = password == confirmPassword

        if (!isNameValid) {
            view?.displayNameFailure(R.string.invalid_username)
        } else {
            view?.displayNameFailure(null)
        }

        if (!isDocumentValid) {
            view?.displayDocumentFailure(R.string.invalid_document)
        } else {
            view?.displayDocumentFailure(null)
        }

        if (!isConfirmValid) {
            view?.displayPasswordFailure(R.string.password_not_equal)

        } else {
            if (!isPasswordValid){
                view?.displayPasswordFailure(R.string.invalid_password)
            } else{
                view?.displayPasswordFailure(null)
            }
        }

        if (isConfirmValid && isPasswordValid && isNameValid && isDocumentValid) {
            view?.showProgress(true)

            repository.create(email, name, document, password, object : RegisterCallback {
                override fun onSuccess() {
                    view?.onCreateSuccess(name)
                }

                override fun onFailure(message: String) {
                    view?.onCreateFailure(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }

            })

        }
    }

    override fun onDestroy() {
        view = null
    }


}