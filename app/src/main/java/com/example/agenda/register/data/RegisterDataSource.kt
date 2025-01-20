package com.example.agenda.register.data

interface RegisterDataSource {
    fun create(email: String, callback: RegisterCallback)

    fun create(email: String, name: String,document: String, password: String, callback: RegisterCallback)
}