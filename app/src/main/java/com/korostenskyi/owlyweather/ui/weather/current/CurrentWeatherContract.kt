package com.korostenskyi.owlyweather.ui.weather.current

import com.korostenskyi.owlyweather.ui.base.BasePresenter
import com.korostenskyi.owlyweather.ui.base.BaseView

interface CurrentWeatherContract {

    interface View: BaseView<Presenter> {
        fun showToastMessage(message: String)
    }

    interface Presenter: BasePresenter {

    }
}