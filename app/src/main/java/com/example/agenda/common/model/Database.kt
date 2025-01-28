package com.example.agenda.common.model

import java.util.UUID

object Database {

    val user = hashSetOf<User>()

    var sessionAuth: User? = null

    init {
        user.add(User(UUID.randomUUID().toString(),"userA@gmail.com","","",""))
        user.add(User(UUID.randomUUID().toString(),"userB@gmail.com","", "", ""))
    }
}