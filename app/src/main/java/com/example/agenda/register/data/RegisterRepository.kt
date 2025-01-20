package com.example.agenda.register.data


class RegisterRepository(private val dataSource: RegisterDataSource) {

    fun create(email: String, callback: RegisterCallback) {
        dataSource.create(email, callback)
    }

    fun create(email: String, name: String,document: String, password: String, callback: RegisterCallback) {
        dataSource.create(email, name, document, password, callback)
    }

}