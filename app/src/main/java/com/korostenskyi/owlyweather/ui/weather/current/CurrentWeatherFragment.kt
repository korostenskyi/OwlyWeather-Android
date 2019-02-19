package com.korostenskyi.owlyweather.ui.weather.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.korostenskyi.owlyweather.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class CurrentWeatherFragment : Fragment() {

    private val viewModel: CurrentWeatherViewModel by viewModel()

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_current_weather, container, false)

        return rootView
    }

    fun showToastMessage(message: String) {
        Toast.makeText(rootView.context, message, Toast.LENGTH_SHORT).show()
    }
}
