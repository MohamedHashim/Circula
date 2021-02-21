package com.mohamedhashim.circula.data.remote.client

import com.mohamedhashim.circula.data.dto.PokemonResponse
import com.mohamedhashim.circula.data.remote.ApiResponse
import com.mohamedhashim.circula.data.remote.service.PokemonService
import com.mohamedhashim.circula.data.remote.transform

/**
 * Created by Mohamed Hashim on 2/20/2021.
 */

class PokemonClient(private val service: PokemonService) {

    fun fetchPokemonList(onResult: (response: ApiResponse<PokemonResponse>) -> Unit) {
        this.service.fetchPokemonList().transform(onResult)
    }
}