package com.korostenskyi.owlyweather.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.korostenskyi.domain.model.Forecast
import com.korostenskyi.owlyweather.R
import com.korostenskyi.owlyweather.utils.IconUtils
import kotlinx.android.synthetic.main.item_weather_forecast.view.*

class MainAdapter(private val forecastList: MutableList<Forecast>) : RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_weather_forecast, parent, false)

        return MainViewHolder(cellForRow)
    }

    override fun getItemCount(): Int = forecastList.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val time = forecastList[position].dateString.substring(10, 16)
        val temperature = (forecastList[position].numericalData.temperature - 273.15).toInt().toString()
        val weatherCondition = forecastList[position].weather[0].title
        val iconDrawable = IconUtils.getIconDrawable(forecastList[position].weather[0].icon)

        holder.itemView.tv_item_time.text = time
        holder.itemView.tv_item_temperature.text = temperature
        holder.itemView.tv_item_weather_name.text = weatherCondition
        holder.itemView.iv_item_weather_icon.setImageDrawable(ResourcesCompat.getDrawable(holder.itemView.resources, iconDrawable, null))
    }

    fun addForecasts(forecasts: List<Forecast>) {
        forecastList.addAll(forecasts)
        notifyDataSetChanged()
    }
}