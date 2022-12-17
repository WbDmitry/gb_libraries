package com.example.gb_libraries.core.nav

import com.example.gb_libraries.ui.user_details.UserDetailsFragment
import com.example.gb_libraries.ui.user_list.UserListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun userList() = FragmentScreen { UserListFragment.newInstance() }
    fun userDetails(userLogin: String) =
        FragmentScreen { UserDetailsFragment.newInstance(userLogin) }
}
