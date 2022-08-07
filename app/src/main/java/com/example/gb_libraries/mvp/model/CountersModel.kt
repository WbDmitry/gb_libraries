package com.example.gb_libraries.mvp.model

class CountersModel {
    private val counters = mutableListOf(0, 0, 0)

    fun next(position: Int): Int {
        return counters[position]++
    }
}
