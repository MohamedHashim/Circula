package com.mohamedhashim.circula.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohamedhashim.circula.data.dto.Pokemon
import com.mohamedhashim.circula.data.local.dao.PokemonDao

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
@Database(entities = [Pokemon::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}
