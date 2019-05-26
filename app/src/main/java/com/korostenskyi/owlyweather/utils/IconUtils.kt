package com.korostenskyi.owlyweather.utils

import com.korostenskyi.owlyweather.R

object IconUtils {

    fun getIconDrawable(name: String): Int {
        return when(name) {
            "01d" -> R.drawable.ic_01d
            "01n" -> R.drawable.ic_01n
            "02d" -> R.drawable.ic_02d
            "02n", "03d", "03n", "04d", "04n" -> R.drawable.ic_03d
            "09d", "09n", "10d", "10n" -> R.drawable.ic_09d
            "11d", "11n" -> R.drawable.ic_11d
            "13d", "13n" -> R.drawable.ic_13d
            else -> R.drawable.ic_50d
        }
    }
}