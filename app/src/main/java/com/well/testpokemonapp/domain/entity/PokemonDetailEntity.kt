package com.well.testpokemonapp.domain.entity

data class PokemonDetailEntity(
    val name: String?,
    val picture: String?,
    val height: Int?,
    val weight:Int?,
    val abilities: List<String>,
)