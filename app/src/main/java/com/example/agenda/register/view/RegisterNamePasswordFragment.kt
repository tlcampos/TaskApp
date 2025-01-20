package com.example.agenda.register.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.agenda.R
import com.example.agenda.common.base.DependencyInjector
import com.example.agenda.common.util.TxtWatcher
import com.example.agenda.databinding.FragmentRegisterNamePasswordBinding
import com.example.agenda.register.RegisterNamePassword
import com.example.agenda.register.presentation.RegisterNamePasswordPresenter

class RegisterNamePasswordFragment : Fragment(R.layout.fragment_register_name_password),
    RegisterNamePassword.View {

    private var binding: FragmentRegisterNamePasswordBinding? = null

    private lateinit var presenter: RegisterNamePassword.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterNamePasswordBinding.bind(view)

        val repository = DependencyInjector.registerEmailRepository()
        presenter = RegisterNamePasswordPresenter(this, repository)

        val email = arguments?.getString(KEY_EMAIL) ?: throw IllegalArgumentException("email not found")

        binding?.let {
            with(it) {
                registerTxtLogin.setOnClickListener {
                    activity?.finish()
                }

                registerBtnRegister.setOnClickListener {
                    presenter.create(
                        email,
                        registerEditDocument.text.toString(),
                        registerEditName.text.toString(),
                        registerEditPassword.text.toString(),
                        registerConfirm.text.toString()
                    )

                }

                registerEditDocument.addTextChangedListener(watcher)
                registerEditDocument.addTextChangedListener(TxtWatcher{
                    displayPasswordFailure(null)
                })
                registerEditName.addTextChangedListener(watcher)
                registerEditName.addTextChangedListener(TxtWatcher{
                    displayNameFailure(null)
                })
                registerEditPassword.addTextChangedListener(watcher)
                registerEditPassword.addTextChangedListener(TxtWatcher{
                    displayPasswordFailure(null)
                })
                registerConfirm.addTextChangedListener(watcher)
                registerConfirm.addTextChangedListener(TxtWatcher{
                    displayPasswordFailure(null)
                })
            }
        }
    }

    override fun showProgress(enabled: Boolean) {
        binding?.registerBtnRegister?.showProgress(enabled)
    }

    override fun displayNameFailure(nameError: Int?) {
        binding?.registerEditNameInput?.error = nameError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passError: Int?) {
        binding?.registerEditPasswordInput?.error = passError?.let { getString(it) }
    }

    override fun displayDocumentFailure(docError: Int?) {
        binding?.registerEditDocumentInput?.error = docError?.let { getString(it) }
    }

    override fun onCreateFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun onCreateSuccess(name: String) {
        //abrir tela home
    }

    override fun onDestroy() {
        binding = null
        presenter.onDestroy()
        super.onDestroy()
    }

    companion object {
        const val KEY_EMAIL = "key_email"
    }

    private val watcher: TxtWatcher = TxtWatcher {
        binding?.registerBtnRegister?.isEnabled = binding?.registerEditDocument?.text.toString().isNotEmpty()
                && binding?.registerEditName?.text.toString().isNotEmpty()
                && binding?.registerEditPassword?.text.toString().isNotEmpty()
                && binding?.registerConfirm?.text.toString().isNotEmpty()
    }
}