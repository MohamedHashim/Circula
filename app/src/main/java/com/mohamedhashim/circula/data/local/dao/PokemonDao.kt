package com.mohamedhashim.circula.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mohamedhashim.circula.data.dto.Pokemon

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemonsList(pokemon: List<Pokemon>)

    @Query("SELECT * FROM Pokemon")
    fun getPokemonsList(): List<Pokemon>

}