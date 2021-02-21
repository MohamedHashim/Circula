package com.mohamedhashim.circula.ui.component.pokemons

import android.os.Bundle
import androidx.lifecycle.LiveData
import com.mohamedhashim.circula.data.dto.Pokemon
import com.mohamedhashim.circula.data.remote.repository.PokemonRepository
import com.mohamedhashim.circula.ui.base.LiveCoroutinesViewModel

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
class PokemonListViewModel constructor(
    private val pokemonRepository: PokemonRepository
) : LiveCoroutinesViewModel() {

    var pokemonListLiveData: LiveData<List<Pokemon>> = launchOnViewModelScope {
        this.pokemonRepository.loadPokemonList {}
    }

    companion object {
        private const val PokemonKey = "Pokemon"
        fun createArguments(pokemon: Pokemon): Bundle {
            val bundle = Bundle()
            bundle.putParcelable(PokemonKey, pokemon)
            return bundle
        }
    }
}