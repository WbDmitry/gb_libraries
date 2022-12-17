package com.example.gb_libraries.ui.main

import com.example.gb_libraries.core.nav.Screens
import com.github.terrakok.cicerone.Router

class MainPresenter(
    private val router: Router
) : MainContract.Presenter() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.userList())
    }

    override fun onBackPressed() {
        router.exit()
    }
}
