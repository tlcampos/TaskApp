package com.example.agenda.common.model

import java.util.UUID

class UserAuth(
    var uuid: String,
    val email: String = "",
    val name: String = "",
    val document: String = "",
    val password: String = ""
//    val postalCode: String = "",
//    val street: String = "",
) {
}