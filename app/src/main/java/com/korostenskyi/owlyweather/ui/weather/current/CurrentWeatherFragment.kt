package com.korostenskyi.owlyweather.ui.weather.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.korostenskyi.owlyweather.R

class CurrentWeatherFragment : Fragment(), CurrentWeatherContract.View {

    override var presenter: CurrentWeatherContract.Presenter = CurrentWeatherPresenter(this)

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_current_weather, container, false)

        presenter.start()

        return rootView
    }

    override fun showToastMessage(message: String) {
        Toast.makeText(rootView.context, message, Toast.LENGTH_SHORT).show()
    }
}
