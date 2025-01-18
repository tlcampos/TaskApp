package com.example.agenda.common.model

import java.util.UUID

object Database {

    val userAuth = hashSetOf<UserAuth>()

    var sessionAuth: UserAuth? = null

    init {
        userAuth.add(UserAuth(UUID.randomUUID(),"userA@gmail.com","12345678"))
        userAuth.add(UserAuth(UUID.randomUUID(),"userB@gmail.com","87654321"))
    }
}