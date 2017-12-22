package com.example.alexmets.kotlincleanarchexample.presentation.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.alexmets.kotlincleanarchexample.R

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            Fragments.Builder(supportFragmentManager)
                    .replace(R.id.content, ItemFragment.newInstance(0))
                    .commit()
        }
    }
}