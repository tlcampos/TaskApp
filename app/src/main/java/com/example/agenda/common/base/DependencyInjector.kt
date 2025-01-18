package com.example.agenda.common.base

import com.example.agenda.login.data.FakeDataSource
import com.example.agenda.login.data.LoginRepository
import com.example.agenda.register.data.FakeRegisterEmailDataSource
import com.example.agenda.register.data.RegisterEmailRepository

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterEmailRepository {
        return RegisterEmailRepository(FakeRegisterEmailDataSource())
    }
}