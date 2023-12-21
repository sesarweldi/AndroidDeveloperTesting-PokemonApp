package com.well.testpokemonapp.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.well.testpokemonapp.domain.entity.PokemonEntity
import com.well.testpokemonapp.domain.usecases.base.NoParams
import com.well.testpokemonapp.domain.usecases.main.GetPokemonUseCase
import com.well.testpokemonapp.presentation.model.DataViewMapper.toListPokemonDataView
import com.well.testpokemonapp.presentation.model.PokemonDataView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase
) : ViewModel() {

    private var userName: String = ""
    val pokemonList = mutableListOf<PokemonDataView>()

    private val _pokemonLiveData = MutableLiveData<List<PokemonDataView>>()
    val pokemonLiveData: LiveData<List<PokemonDataView>>
        get() = _pokemonLiveData

    private val _pokemonErrorLiveData = MutableLiveData<Throwable>()
    val pokemonErrorLiveData: LiveData<Throwable>
        get() = _pokemonErrorLiveData

    private val _clickPokemonItemEventLiveData = MutableLiveData<PokemonDataView>()
    val clickPokemonItemEventLiveData: LiveData<PokemonDataView>
        get() = _clickPokemonItemEventLiveData

    fun getPokemon() {
        executeGetUserSearchUseCase()
    }

    private fun executeGetUserSearchUseCase() {
        getPokemonUseCase.execute(
            ::onGetPokemonSuccess,
            ::onGetUserSearchFailed,
            NoParams()
        )
    }

    private fun onGetPokemonSuccess(data: PokemonEntity) {
        val isEmptyList = data.pokemonList?.isEmpty() ?: true
        val itemList = data.toListPokemonDataView() ?: listOf()

        cretePokemonList(itemList, isEmptyList)
        updateView()
    }

    private fun cretePokemonList(data: List<PokemonDataView>, isEmptyList: Boolean) {
        pokemonList.clear()

        if (isEmptyList) showEmptyState()
        else pokemonList.addAll(data)
    }

    private fun showEmptyState() {
    }

    private fun updateView() {
        _pokemonLiveData.postValue(pokemonList)
    }

    private fun onGetUserSearchFailed(throwable: Throwable) {
        _pokemonErrorLiveData.postValue(throwable)
    }

    fun onItemPokemonClicked(data: PokemonDataView) {
        _clickPokemonItemEventLiveData.postValue(data)
    }

    fun clearData() {
        pokemonList.clear()
        _pokemonLiveData.postValue(pokemonList)
    }
}