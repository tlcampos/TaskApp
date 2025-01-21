package com.example.agenda.register.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.agenda.MainActivity
import com.example.agenda.R
import com.example.agenda.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), FragmentAttachListener {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val fragment = RegisterEmailFragment()
        replaceFragment(fragment)

    }

    override fun goToNameAndPasswordFragment(email: String) {
        val fragment = RegisterNamePasswordFragment().apply {
            arguments = Bundle().apply {
                putString("key_email", email)
            }
        }

        replaceFragment(fragment)

    }

    override fun goToHomeScreen(name: String) {
        val arguments = Bundle().apply {
            putString("key_name", name)
        }
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtras(arguments)
        }
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun replaceFragment(fragment: Fragment) {
        if (supportFragmentManager.findFragmentById(R.id.register_fragment) == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.register_fragment, fragment)
                commit()
            }
        } else {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.register_fragment, fragment)
                addToBackStack(null)
                commit()
            }

        }

    }
}