package com.example.agenda.common.model

import java.util.UUID

object Database {

    val userAuth = hashSetOf<UserAuth>()

    var sessionAuth: UserAuth? = null

    init {
        userAuth.add(UserAuth(UUID.randomUUID().toString(),"userA@gmail.com","","",""))
        userAuth.add(UserAuth(UUID.randomUUID().toString(),"userB@gmail.com","", "", ""))
    }
}