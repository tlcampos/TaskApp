package com.example.agenda.login.data

interface LoginCallback {
    fun onSuccess()
    fun onFailure(message: String)
    fun onComplete()
}