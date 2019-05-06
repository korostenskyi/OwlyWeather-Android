package com.korostenskyi.owlyweather.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.korostenskyi.owlyweather.R
import com.korostenskyi.owlyweather.data.entity.ForecastBody
import kotlinx.android.synthetic.main.item_weather_forecast.view.*

class MainAdapter(private val forecastList: List<ForecastBody>) : RecyclerView.Adapter<MainViewHolder>() {

    private val itemCount = forecastList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_weather_forecast, parent, false)

        return MainViewHolder(cellForRow)
    }

    override fun getItemCount(): Int = itemCount

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val time = forecastList[position].dateString.substring(10, 16)
        val temperature = (forecastList[position].numericalData.temperature - 273.15).toInt().toString()
        val weatherCondition = forecastList[position].weather[0].title

        holder.itemView.tv_item_time.text = time
        holder.itemView.tv_item_temperature.text = temperature
        holder.itemView.tv_item_weather_name.text = weatherCondition
    }
}