package com.example.agenda

import com.example.agenda.common.model.User

interface UserDataSource {

    fun fetchUser(userUUID: String, callback: UserCallback<Pair<User, Boolean?>>)
}