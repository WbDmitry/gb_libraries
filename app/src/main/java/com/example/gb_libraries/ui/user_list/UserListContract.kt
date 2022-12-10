package com.example.gb_libraries.ui.user_list

import com.example.gb_libraries.model.GithubUser
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

class UserListContract {
    @AddToEndSingle
    interface View : MvpView {
        fun init()
        fun updateList()
    }

    abstract class Presenter : MvpPresenter<View>() {
        abstract fun loadData()
        abstract fun loadUser(position: Int): GithubUser
        abstract fun backPressed(): Boolean
    }
}
