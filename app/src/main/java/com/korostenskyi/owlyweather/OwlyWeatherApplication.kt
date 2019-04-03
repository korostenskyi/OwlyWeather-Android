package com.korostenskyi.owlyweather

import android.app.Application
import com.korostenskyi.owlyweather.di.appModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class OwlyWeatherApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(appModule)
    }
}