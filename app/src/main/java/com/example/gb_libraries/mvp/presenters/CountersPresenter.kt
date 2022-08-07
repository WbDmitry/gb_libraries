package com.example.gb_libraries.mvp.presenters

import com.example.gb_libraries.mvp.model.CountersModel
import com.example.gb_libraries.mvp.view.MainView


class CountersPresenter(
    private val view: MainView
) {
    private val model = CountersModel()

    fun onClickButton1() {
        val newValue = model.next(ID_BUTTON_1)
        view.setTextButton1(newValue.toString())
    }

    fun onClickButton2() {
        val newValue = model.next(ID_BUTTON_2)
        view.setTextButton2(newValue.toString())
    }

    fun onClickButton3() {
        val newValue = model.next(ID_BUTTON_3)
        view.setTextButton3(newValue.toString())
    }

    companion object {
        private const val ID_BUTTON_1 = 0
        private const val ID_BUTTON_2 = 1
        private const val ID_BUTTON_3 = 2
    }
}
