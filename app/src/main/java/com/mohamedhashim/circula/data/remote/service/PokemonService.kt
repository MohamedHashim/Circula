package com.mohamedhashim.circula.data.remote.service

import com.mohamedhashim.circula.data.dto.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Mohamed Hashim on 2/20/2021.
 */

interface PokemonService {

    @GET("pokemon")
    fun fetchPokemonList(): Call<PokemonResponse>
}
