package com.mohamedhashim.circula.di

import com.mohamedhashim.circula.data.remote.repository.PokemonRepository
import org.koin.dsl.module

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
val repositoryModule = module {
    single { PokemonRepository(get()) }
}