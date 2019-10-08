package com.korostenskyi.owlyweather.ui

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.korostenskyi.owlyweather.R
import com.korostenskyi.owlyweather.utils.IconUtils
import com.korostenskyi.owlyweather.utils.NetworkUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val sdf by lazy { SimpleDateFormat("dd.MM hh:mm:ss") }
    private val weatherAdapter by lazy { MainAdapter(mutableListOf()) }

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        bindUi()

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this@MainActivity)

        if (NetworkUtils.isNetworkAvailable(this@MainActivity)) {
            updateCurrentLocation()
        } else {
            showToast("No network connection...")
        }
    }

    private fun initRecyclerView() {
        rv_weather_forecast.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            adapter = weatherAdapter
        }
    }

    private fun bindUi() {
        viewModel.apply {
            currentWeatherLiveData.observe(this@MainActivity, Observer { currentWeather ->
                // TODO: Placeholders
                tv_temperatureBig.text = "${(currentWeather.numericalData.temperature - 273.15).toInt()}°"
                tv_cityName.text = currentWeather.cityName
                tv_windSpeed.text = currentWeather.wind.speed.toString()
                tv_humidityPercent.text = currentWeather.numericalData.humidity.toString()
                tv_condition.text = currentWeather.weather[0].title
                iv_weatherIcon.setImageDrawable(ResourcesCompat.getDrawable(resources, IconUtils.getIconDrawable(currentWeather.weather[0].icon), null))
                tv_date.text = sdf.format(Date())
            })
            forecastWeatherLiveData.observe(this@MainActivity, Observer { weatherForecast ->
                weatherAdapter.addForecasts(weatherForecast.forecastList)
            })
        }
    }

    //TODO: Rewrite
    private fun updateCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this@MainActivity, ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.lastLocation.addOnSuccessListener { loadData(49.04, 24.01) }
        } else {
            requestPermission()
            updateCurrentLocation()
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this@MainActivity, arrayOf(ACCESS_FINE_LOCATION), PLACE_REQUEST)
    }

    private fun loadData(lat: Double, lon: Double) {
        GlobalScope.launch(Dispatchers.IO) {
            viewModel.apply {
                fetchCurrentWeather(lat, lon)
                fetchForecastWeather(lat, lon)
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val PLACE_REQUEST = 1
    }
}
