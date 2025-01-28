package com.example.agenda.common.base

import com.example.agenda.login.data.FireLoginDataSource
import com.example.agenda.login.data.LoginRepository
import com.example.agenda.register.data.FireRegisterDataSource
import com.example.agenda.register.data.RegisterRepository

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(FireLoginDataSource())
    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FireRegisterDataSource())
    }
}