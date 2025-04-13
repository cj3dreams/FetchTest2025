package com.fetchtest.fetch.app

import android.app.Application
import com.fetchtest.fetch.app.di.dataSourceModule
import com.fetchtest.fetch.app.di.networkModule
import com.fetchtest.fetch.app.di.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(networkModule, dataSourceModule, viewModel)
        }
    }
}