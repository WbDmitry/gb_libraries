package com.example.gb_libraries.core.nav

import com.example.gb_libraries.ui.user_details.UserDetailsFragment
import com.example.gb_libraries.ui.user_list.UserListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun openUserListFragment() = FragmentScreen { UserListFragment.newInstance() }
    fun openUserDetailsFragment(userLogin: String) =
        FragmentScreen { UserDetailsFragment.newInstance(userLogin) }
}
