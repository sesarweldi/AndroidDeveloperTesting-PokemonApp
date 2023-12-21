package com.well.testpokemonapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.well.testpokemonapp.domain.entity.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

}