package com.example.agenda.login.data

interface LoginDataSource {
    fun login(email: String, password: String, callback: LoginCallback)
}