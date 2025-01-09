package com.example.agenda

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.agenda.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editEmail = binding.loginEditEmail
        val editPassword = binding.loginEditPassword

        editEmail.addTextChangedListener(watcher)
        editPassword.addTextChangedListener(watcher)

        binding.loginBtnEnter.setOnClickListener {

            binding.loginEditEmailInput
                .error = "Esse e-mail é invalido"

            binding.loginEditPasswordInput
                .error = "Essa Incorreta"
        }
    }

    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding.loginBtnEnter.isEnabled = s.toString().isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {
        }

    }
}