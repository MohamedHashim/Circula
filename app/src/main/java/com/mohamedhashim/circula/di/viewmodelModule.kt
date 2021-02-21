package com.mohamedhashim.circula.di

import com.mohamedhashim.circula.ui.component.pokemons.PokemonListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
val viewModelModule = module {
    viewModel { PokemonListViewModel(get()) }
}