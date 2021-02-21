package com.mohamedhashim.circula

import android.app.Application
import com.mohamedhashim.circula.di.networkModule
import com.mohamedhashim.circula.di.persistenceModule
import com.mohamedhashim.circula.di.repositoryModule
import com.mohamedhashim.circula.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Mohamed Hashim on 2/20/2021.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(networkModule)
            modules(viewModelModule)
            modules(repositoryModule)
            modules(persistenceModule)
        }
    }
}