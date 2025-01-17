package com.example.agenda.common.base

import com.example.agenda.login.data.FakeDataSource
import com.example.agenda.login.data.LoginRepository

object DependecyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }
}