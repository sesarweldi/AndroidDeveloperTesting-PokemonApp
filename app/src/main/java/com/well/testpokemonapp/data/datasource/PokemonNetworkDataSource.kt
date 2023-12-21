package com.well.testpokemonapp.data.datasource

import com.well.testpokemonapp.data.api.ApiUrlConstant
import com.well.testpokemonapp.data.response.PokemonDetailResponseModel
import com.well.testpokemonapp.data.response.PokemonResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonNetworkDataSource {

    @GET("${ApiUrlConstant.API}/${ApiUrlConstant.V2}/${ApiUrlConstant.POKEMON}")
    suspend fun getPokemon(): PokemonResponseModel

    @GET("${ApiUrlConstant.API}/${ApiUrlConstant.V2}/${ApiUrlConstant.POKEMON}/{name}")
    suspend fun getDetailPokemon(
        @Path("name") name: String,
    ): PokemonDetailResponseModel
}