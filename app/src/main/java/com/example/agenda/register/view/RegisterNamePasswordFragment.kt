package com.example.agenda.register.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.agenda.R
import com.example.agenda.databinding.FragmentRegisterEmailBinding
import com.example.agenda.databinding.FragmentRegisterNamePasswordBinding

class RegisterNamePasswordFragment : Fragment(R.layout.fragment_register_name_password) {

    private var binding: FragmentRegisterNamePasswordBinding? = null
   // private var fragmentAttachListener: FragmentAttachListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterNamePasswordBinding.bind(view)
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is FragmentAttachListener) {
//            fragmentAttachListener = context
//        }
//    }

    override fun onDestroy() {
        binding = null
        //fragmentAttachListener = null
        //presenter.onDestroy()
        super.onDestroy()
    }

    companion object {
        const val KEY_EMAIL = "key_email"
    }
}