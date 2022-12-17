package com.example.gb_libraries.ui.user_list

import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

class UserListContract {
    @AddToEndSingle
    interface View : MvpView {
        fun init()
        fun updateList()
        fun showError(message: String)
    }

    abstract class Presenter : MvpPresenter<View>() {
        abstract fun loadData()
        abstract fun backPressed(): Boolean
    }
}
