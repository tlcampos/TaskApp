package com.example.agenda.common.base

import com.example.agenda.login.data.FakeDataSource
import com.example.agenda.login.data.LoginRepository
import com.example.agenda.register.data.FakeRegisterDataSource
import com.example.agenda.register.data.FireRegisterDataSource
import com.example.agenda.register.data.RegisterRepository

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FireRegisterDataSource())
    }
}