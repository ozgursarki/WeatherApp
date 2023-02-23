package com.ozgursarki.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozgursarki.weatherapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}