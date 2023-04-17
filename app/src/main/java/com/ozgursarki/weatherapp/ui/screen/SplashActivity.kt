package com.ozgursarki.weatherapp.ui.screen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View
import com.ozgursarki.weatherapp.R
import com.ozgursarki.weatherapp.ui.MainActivity

class SplashActivity : AppCompatActivity() {

    private val splashScreenTimeout: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)


    }

    override fun onResume() {
        super.onResume()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashScreenTimeout)
    }
}