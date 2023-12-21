package com.well.testpokemonapp.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("pokemon")
data class PokemonEntity(
    @PrimaryKey val name: String
)