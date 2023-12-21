package com.well.testpokemonapp.data.datasource

import com.well.testpokemonapp.data.DataConstant
import com.well.testpokemonapp.data.response.PokemonDetailResponseModel
import com.well.testpokemonapp.data.response.PokemonResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonNetworkDataSource {

    @GET("${DataConstant.API}/${DataConstant.V2}/${DataConstant.POKEMON}")
    suspend fun getPokemon(): PokemonResponseModel

    @GET("${DataConstant.API}/${DataConstant.V2}/${DataConstant.POKEMON}/{name}")
    suspend fun getDetailPokemon(
        @Path("name") name: String,
    ): PokemonDetailResponseModel
}