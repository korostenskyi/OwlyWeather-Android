package com.korostenskyi.owlyweather.ui.weather.current

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.korostenskyi.owlyweather.R
import com.korostenskyi.owlyweather.data.network.entity.OpenWeather.CurrentWeather
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import kotlin.coroutines.CoroutineContext

class CurrentWeatherFragment : Fragment(), CoroutineScope, KodeinAware {

    override val kodein: Kodein by closestKodein()

    // TODO: Move it to BaseFragment
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewModelFactory: CurrentWeatherViewModelFactory by instance()
    private lateinit var viewModel: CurrentWeatherViewModel

    private lateinit var rootView: View

    private var weatherLiveData = MutableLiveData<CurrentWeather>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_current_weather, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CurrentWeatherViewModel::class.java)

        loadData()
    }

    private fun loadData() {
        launch {
            weatherLiveData = viewModel.currentWeather

            weatherLiveData.observe(this@CurrentWeatherFragment, Observer { currentWeather ->
                if (currentWeather == null) {
                    showToastMessage("Something went wrong...")
                    return@Observer
                }

                Log.i("CurrentWeatherFragment", currentWeather.name)
            })

            viewModel.fetchCurrentWeather(49.8397, 24.0297)
        }
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(rootView.context, message, Toast.LENGTH_SHORT).show()
    }
}
