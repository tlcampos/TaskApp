package com.example.agenda.common.base

import com.example.agenda.login.data.FireLoginDataSource
import com.example.agenda.login.data.LoginRepository
import com.example.agenda.register.data.FireRegisterDataSource
import com.example.agenda.register.data.RegisterRepository
import com.example.agenda.splash.data.FakeLocalDataSource
import com.example.agenda.splash.data.SplashRepository

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(FireLoginDataSource())
    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FireRegisterDataSource())
    }

    fun splashRepository(): SplashRepository {
        return SplashRepository(FakeLocalDataSource())
    }
}