package com.example.agenda.login.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda.common.util.TxtWatcher
import com.example.agenda.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {
            loginEditEmail.addTextChangedListener(watcher)
            loginEditPassword.addTextChangedListener(watcher)

            val btnEnter = binding.loginBtnEnter

            btnEnter.setOnClickListener {
                btnEnter.showProgress(true)

                binding.loginEditEmailInput
                    .error = "Esse e-mail é invalido"

                binding.loginEditPasswordInput
                    .error = "Senha Incorreta"

                Handler(Looper.getMainLooper()).postDelayed({
                    btnEnter.showProgress(false)
                }, 2000)
            }
        }
    }

    private val watcher = TxtWatcher {
        binding.loginBtnEnter.isEnabled = it.isNotEmpty()
    }

}