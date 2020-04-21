package com.korostenskyi.owlyweather.ui

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.FusedLocationProviderClient
import com.korostenskyi.owlyweather.R
import com.korostenskyi.owlyweather.utils.IconUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
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
        initExtra()
        requestPermission()
    }

    private fun initRecyclerView() {
        rvWeatherForecast.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            adapter = weatherAdapter
        }
    }

    private fun loadData() {
        lifecycleScope.launch {
            viewModel.apply {
                fetchCurrentWeather().collect { currentWeather ->
                    // TODO: Placeholders
                    tvTemperatureBig.text = "${(currentWeather.numericalData.temperature - 273.15).toInt()}°"
                    tvCityName.text = currentWeather.cityName
                    tvWindSpeed.text = currentWeather.wind.speed.toString()
                    tvHumidityPercent.text = currentWeather.numericalData.humidity.toString()
                    tvCondition.text = currentWeather.weather[0].title
                    ivWeatherIcon.setImageDrawable(ResourcesCompat.getDrawable(resources, IconUtils.getIconDrawable(currentWeather.weather[0].icon), null))
                    tvDate.text = sdf.format(Date())
                }
                fetchForecastWeather().collect { weatherForecast ->
                    weatherAdapter.addForecasts(weatherForecast.forecastList)
                }
            }
        }
    }

    private fun initExtra() {
        fusedLocationProviderClient = FusedLocationProviderClient(this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PLACE_REQUEST -> {
                if (grantResults.isNotEmpty() && grantResults[0] != PackageManager.PERMISSION_GRANTED) requestPermission()
                else loadData()
            }
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this@MainActivity, arrayOf(ACCESS_FINE_LOCATION), PLACE_REQUEST)
    }

    companion object {
        private const val PLACE_REQUEST = 1
    }
}
