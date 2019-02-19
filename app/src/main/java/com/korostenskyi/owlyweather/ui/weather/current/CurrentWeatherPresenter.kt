package com.korostenskyi.owlyweather.ui.weather.current

class CurrentWeatherPresenter(private val view: CurrentWeatherContract.View): CurrentWeatherContract.Presenter {

    override fun start() {
        view.showToastMessage("Hello")
    }
}