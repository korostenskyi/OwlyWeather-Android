package com.korostenskyi.owlyweather.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.korostenskyi.owlyweather.R

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private val itemCount = 4

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_weather_forecast, parent, false)

        return MainViewHolder(cellForRow)
    }

    override fun getItemCount(): Int = itemCount

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) { }
}