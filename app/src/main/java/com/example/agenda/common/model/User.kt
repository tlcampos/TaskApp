package com.example.agenda.common.model

class User(
    var uuid: String,
    val email: String = "",
    val name: String = "",
    val document: String = "",
    val password: String = ""
//    val postalCode: String = "",
//    val street: String = "",
) {
}