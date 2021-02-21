package com.mohamedhashim.circula.di

import androidx.room.Room
import com.mohamedhashim.circula.R
import com.mohamedhashim.circula.data.local.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
val persistenceModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), AppDatabase::class.java,
            androidApplication().getString(R.string.database)
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().pokemonDao() }
}