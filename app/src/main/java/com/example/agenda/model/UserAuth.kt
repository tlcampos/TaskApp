package com.example.agenda.model

import java.util.UUID

class UserAuth(
    var uuid: UUID?,
    val email: String = "",
    val password: String = ""
//    val name: String = "",
//    val document: String = "",
//    val postalCode: String = "",
//    val street: String = "",
) {
}