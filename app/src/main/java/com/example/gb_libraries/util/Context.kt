package com.example.gb_libraries.util

import android.content.Context
import com.example.gb_libraries.App

val Context.app: App
    get() {
        return applicationContext as App
    }