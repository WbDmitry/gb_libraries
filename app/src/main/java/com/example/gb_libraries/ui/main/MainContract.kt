package com.example.gb_libraries.ui.main

import moxy.MvpPresenter
import moxy.MvpView

class MainContract {
    interface View : MvpView

    abstract class Presenter : MvpPresenter<View>() {
        abstract fun onBackPressed()
    }
}