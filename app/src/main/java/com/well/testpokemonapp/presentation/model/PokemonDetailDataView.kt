package com.well.testpokemonapp.presentation.model

data class PokemonDetailDataView(
    val name: String?,
    val picture: String?,
    val height: Int?,
    val weight: Int?,
    val abilities: List<String>,
) {

}
