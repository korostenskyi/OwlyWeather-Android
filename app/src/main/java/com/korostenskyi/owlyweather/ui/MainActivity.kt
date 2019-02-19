package com.korostenskyi.owlyweather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.korostenskyi.owlyweather.R
import com.korostenskyi.owlyweather.ui.weather.current.CurrentWeatherFragment

class MainActivity : AppCompatActivity() {

    private val LAYOUT = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)

        switchToFragment(CurrentWeatherFragment())
    }

    private fun switchToFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction().replace(R.id.fl_fragment_container, fragment).commit()
    }
}
