package com.example.gb_libraries.ui.main

import android.os.Bundle
import com.example.gb_libraries.R
import com.example.gb_libraries.core.OnBackPressedListener
import com.example.gb_libraries.databinding.ActivityMainBinding
import com.example.gb_libraries.util.app
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainContract.View {
    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter(app.router) }
    private val navigator by lazy { AppNavigator(this, R.id.main_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        app.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        app.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { currentFragment ->
            if (currentFragment is OnBackPressedListener && currentFragment.onBackPressed()) {
                return
            }
        }
        presenter.onBackPressed()
    }
}