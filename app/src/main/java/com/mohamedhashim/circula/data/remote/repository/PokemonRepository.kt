package com.mohamedhashim.circula.data.remote.repository

import androidx.lifecycle.MutableLiveData
import com.mohamedhashim.circula.data.dto.Pokemon
import com.mohamedhashim.circula.data.local.dao.PokemonDao
import com.mohamedhashim.circula.data.remote.ApiResponse
import com.mohamedhashim.circula.data.remote.client.PokemonClient
import com.mohamedhashim.circula.data.remote.message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
class PokemonRepository constructor(
    private val pokemonClient: PokemonClient,
    private val pokemonDao: PokemonDao
) {

    suspend fun loadPokemonList(error: (String) -> Unit) =
        withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<Pokemon>>()
            var pokemons = emptyList<Pokemon>()
            pokemonClient.fetchPokemonList { response ->
                when (response) {
                    is ApiResponse.Success -> {
                        response.data?.let { data ->
                            pokemons = data.pokemons
                            pokemonDao.insertPokemonsList(pokemons)
                            liveData.postValue(pokemons)
                        }
                    }
                    is ApiResponse.Failure.Error -> {
                        error(response.message())
                        pokemons = getLocalPokemons()
                        liveData.postValue(pokemons)
                    }
                    is ApiResponse.Failure.Exception -> {
                        error(response.message())
                        pokemons = getLocalPokemons()
                        liveData.postValue(pokemons)
                    }
                }
            }
            liveData.apply { postValue(pokemons) }
        }

    fun getLocalPokemons() = pokemonDao.getPokemonsList()
}