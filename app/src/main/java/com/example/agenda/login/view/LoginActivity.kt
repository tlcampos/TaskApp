package com.example.agenda.login.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda.MainActivity
import com.example.agenda.common.base.DependecyInjector
import com.example.agenda.common.util.TxtWatcher
import com.example.agenda.databinding.ActivityLoginBinding
import com.example.agenda.login.Login
import com.example.agenda.login.data.FakeDataSource
import com.example.agenda.login.data.LoginRepository
import com.example.agenda.login.presentation.LoginPresenter

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var presenter: Login.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        presenter = LoginPresenter(this, DependecyInjector.loginRepository())

        with(binding) {
            loginEditEmail.addTextChangedListener(watcher)
            loginEditEmail.addTextChangedListener(TxtWatcher{
                displayEmailFailure(null)
            })

            loginEditPassword.addTextChangedListener(watcher)
            loginEditPassword.addTextChangedListener(TxtWatcher{
                displayPasswordFailure(null)
            })

            val btnEnter = binding.loginBtnEnter

            btnEnter.setOnClickListener {
                presenter.login(loginEditEmail.text.toString(), loginEditPassword.text.toString())
            }
        }
    }
    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TxtWatcher {
        binding.loginBtnEnter.isEnabled = binding.loginEditEmail.text.toString().isNotEmpty()
                && binding.loginEditPassword.text.toString().isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        binding.loginBtnEnter.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding.loginEditEmailInput
            .error = emailError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.loginEditPasswordInput
            .error = passwordError?.let { getString(it) }
    }

    override fun onUserAuthenticated() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun onUserUnauthorized(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}