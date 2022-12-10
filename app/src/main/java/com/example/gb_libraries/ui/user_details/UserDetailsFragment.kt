package com.example.gb_libraries.ui.user_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gb_libraries.databinding.FragmentUserDetailsBinding

class UserDetailsFragment : Fragment() {
    companion object {
        const val USER_LOGIN = "login"
        fun newInstance(userLogin: String) =
            UserDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(USER_LOGIN, userLogin)
                }
            }
    }

    private var _binding: FragmentUserDetailsBinding? = null
    private val binding get() = _binding!!

    private var userLogin: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userLogin = it.getString(USER_LOGIN)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailsBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        userLogin?.let {
            binding.userLoginTextView.text = it
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}