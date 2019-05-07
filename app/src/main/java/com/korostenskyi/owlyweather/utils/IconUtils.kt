package com.korostenskyi.owlyweather.utils

import com.korostenskyi.owlyweather.R

object IconUtils {

    fun getIconDrawable(name: String): Int {
        return when(name) {
            "01d" -> R.drawable.ic_01d
            "01n" -> R.drawable.ic_01n
            "02d" -> R.drawable.ic_02d
            "02n" -> R.drawable.ic_03d
            "03d" -> R.drawable.ic_03d
            "03n" -> R.drawable.ic_03d
            "04d" -> R.drawable.ic_03d
            "04n" -> R.drawable.ic_03d
            "09d" -> R.drawable.ic_09d
            "09n" -> R.drawable.ic_09d
            "10d" -> R.drawable.ic_09d
            "10n" -> R.drawable.ic_09d
            "11d" -> R.drawable.ic_11d
            "11n" -> R.drawable.ic_11d
            "13d" -> R.drawable.ic_13d
            "13n" -> R.drawable.ic_13d
            "50d" -> R.drawable.ic_50d
            "50n" -> R.drawable.ic_50d
            else -> R.drawable.ic_01d
        }
    }
}