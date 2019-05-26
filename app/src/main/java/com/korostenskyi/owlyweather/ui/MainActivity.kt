package com.korostenskyi.owlyweather.ui

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.korostenskyi.owlyweather.R
import com.korostenskyi.owlyweather.data.entity.WeatherCurrentResponse
import com.korostenskyi.owlyweather.data.entity.WeatherForecastResponse
import com.korostenskyi.owlyweather.utils.IconUtils
import com.korostenskyi.owlyweather.utils.NetworkUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.CoroutineContext

private const val PLACE_REQUEST = 1

class MainActivity : AppCompatActivity(), CoroutineScope {

    private val LAYOUT = R.layout.activity_main

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewModel: MainViewModel by inject()

    private var weatherLiveData = MutableLiveData<WeatherCurrentResponse>()
    private var forecastLiveData = MutableLiveData<WeatherForecastResponse>()

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this@MainActivity)

        initRecyclerView()
        loadData(49.8397, 24.0297)

        if (NetworkUtils.isNetworkAvailable(this@MainActivity)) {
            btn_update_location.setOnClickListener {
                updateCurrentLocation()
            }
        } else {
            showToast("No network connection...")
        }
    }

    private fun updateCurrentLocation() {

        if (ActivityCompat.checkSelfPermission(this@MainActivity, ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.lastLocation.addOnSuccessListener {
                loadData(it.latitude, it.longitude)
            }
        } else {
            requestPermission()
            updateCurrentLocation()
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this@MainActivity, arrayOf(ACCESS_FINE_LOCATION), PLACE_REQUEST)
    }

    private suspend fun sendCurrentWeatherRequest(lat: Double, lon: Double) {
        weatherLiveData = viewModel.currentWeather

        weatherLiveData.observe(this@MainActivity, Observer { currentWeather ->
            if (currentWeather == null) {
                showToast("Something went wrong...")
                return@Observer
            }

            updateUI()
        })

        viewModel.fetchCurrentWeather(lat, lon)
    }

    private suspend fun sentForecastWeatherRequest(lat: Double, lon: Double) {
        forecastLiveData = viewModel.forecastWeather

        forecastLiveData.observe(this@MainActivity, Observer { forecastWeather ->
            if (forecastWeather == null) {
                showToast("Something went wrong...")
                return@Observer
            }

            rv_weather_forecast.adapter = MainAdapter(forecastWeather.forecastList)
        })

        viewModel.fetchForecastWeather(lat, lon)
    }

    private fun loadData(lat: Double, lon: Double) {
        launch {
            sendCurrentWeatherRequest(lat, lon)
            sentForecastWeatherRequest(lat, lon)
        }
    }

    private fun updateUI() {

        val temperature = (weatherLiveData.value?.numericalData?.temperature!! - 273.15).toInt()

        tv_temperatureBig.text = "$temperature°"
        tv_cityName.text = weatherLiveData.value?.cityName
        tv_windSpeed.text = weatherLiveData.value?.wind?.speed?.toInt().toString()
        tv_humidityPercent.text = weatherLiveData.value?.numericalData!!.humidity.toString()
        tv_condition.text = weatherLiveData.value?.weather?.get(0)?.title
        iv_weatherIcon.setImageDrawable(ResourcesCompat.getDrawable(resources, IconUtils.getIconDrawable(weatherLiveData.value?.weather?.get(0)?.icon!!), null))

        val sdf = SimpleDateFormat("dd.MM hh:mm:ss")
        val currentDate = sdf.format(Date())
        tv_date.text = currentDate
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.HORIZONTAL, false)

        rv_weather_forecast.layoutManager = linearLayoutManager
        rv_weather_forecast.adapter = MainAdapter(listOf())
    }

    private fun showToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}
