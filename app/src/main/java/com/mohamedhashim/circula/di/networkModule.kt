package com.mohamedhashim.circula.di

import com.mohamedhashim.circula.BASE_URL
import com.mohamedhashim.circula.data.remote.RequestInterceptor
import com.mohamedhashim.circula.data.remote.client.PokemonClient
import com.mohamedhashim.circula.data.remote.service.PokemonService
import com.mohamedhashim.circula.timeoutConnect
import com.mohamedhashim.circula.timeoutRead
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .connectTimeout(timeoutConnect.toLong(), TimeUnit.SECONDS)
            .readTimeout(timeoutRead.toLong(), TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(PokemonService::class.java) }

    single { PokemonClient(get()) }
}