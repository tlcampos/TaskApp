package com.example.agenda.login.data

import com.example.agenda.common.model.UserAuth

interface LoginCallback {
    fun onSuccess()
    fun onFailure(message: String)
    fun onComplete()
}