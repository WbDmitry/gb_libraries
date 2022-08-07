package com.example.gb_libraries.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gb_libraries.databinding.ActivityMainBinding
import com.example.gb_libraries.mvp.presenters.CountersPresenter
import com.example.gb_libraries.mvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            button1.setOnClickListener {
                presenter.onClickButton1()
            }

            button2.setOnClickListener {
                presenter.onClickButton2()
            }

            button3.setOnClickListener {
                presenter.onClickButton3()
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setTextButton1(counter: String) {
        binding.tvText1.text = counter
    }

    override fun setTextButton2(counter: String) {
        binding.tvText2.text = counter
    }

    override fun setTextButton3(counter: String) {
        binding.tvText3.text = counter
    }
}
