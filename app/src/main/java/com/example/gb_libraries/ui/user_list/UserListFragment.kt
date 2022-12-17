package com.example.gb_libraries.ui.user_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gb_libraries.core.OnBackPressedListener
import com.example.gb_libraries.databinding.FragmentUserListBinding
import com.example.gb_libraries.repository.impl.GithubRepositoryImpl
import com.example.gb_libraries.util.app
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserListFragment : MvpAppCompatFragment(), UserListContract.View, OnBackPressedListener {
    companion object {
        fun newInstance() = UserListFragment()
    }

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    private val presenter: UserListPresenter by moxyPresenter {
        UserListPresenter(
            GithubRepositoryImpl(),
            requireActivity().app.router
        )
    }

    private lateinit var adapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun init() {
        binding.rvGithubUsers.layoutManager = LinearLayoutManager(context)
        adapter = UserListAdapter(presenter.usersListPresenter)
        binding.rvGithubUsers.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun showError(message: String) {
        view?.let { Snackbar.make(it, message, Snackbar.LENGTH_SHORT) }
    }

    override fun onBackPressed() = presenter.backPressed()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
