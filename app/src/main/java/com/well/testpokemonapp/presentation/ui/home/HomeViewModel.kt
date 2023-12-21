package com.well.testpokemonapp.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.well.testpokemonapp.domain.entity.PokemonEntity
import com.well.testpokemonapp.domain.usecases.base.NoParams
import com.well.testpokemonapp.domain.usecases.main.GetLocalPokemonListUseCase
import com.well.testpokemonapp.domain.usecases.main.GetPokemonUseCase
import com.well.testpokemonapp.domain.usecases.main.InsertLocalPokemonUseCase
import com.well.testpokemonapp.presentation.model.DataViewMapper.toListPokemonDataView
import com.well.testpokemonapp.presentation.model.PokemonDataView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
    private val insertLocalPokemonUseCase: InsertLocalPokemonUseCase,
    private val getLocalPokemonListUseCase: GetLocalPokemonListUseCase
) : ViewModel() {

    init {
        getLocalPokemon()
    }

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
        if (pokemonLiveData.value == null ){
            executeGetPokemonUseCase()
        }
    }

    private fun executeGetPokemonUseCase() {
        getPokemonUseCase.execute(
            ::onGetPokemonSuccess,
            ::onGetPokemonFailed,
            NoParams()
        )
    }

    private fun onGetPokemonSuccess(data: List<PokemonEntity>) {
        insertToDatabase(data)
        getLocalPokemon()
    }

    private fun insertToDatabase(data: List<PokemonEntity>) {
        insertDatabase(data)
    }


    private fun cretePokemonList(data: List<PokemonDataView>) {
        pokemonList.clear()
        pokemonList.addAll(data)
    }

    private fun updateView() {
        _pokemonLiveData.postValue(pokemonList)
    }

    private fun onGetPokemonFailed(throwable: Throwable) {
        _pokemonErrorLiveData.postValue(throwable)
    }

    fun onItemPokemonClicked(data: PokemonDataView) {
        _clickPokemonItemEventLiveData.postValue(data)
    }

    private fun getLocalPokemon() {
        viewModelScope.launch {
            getLocalPokemonListUseCase().collect {
                _pokemonLiveData.postValue(it.toListPokemonDataView())
                cretePokemonList(it.toListPokemonDataView())
                updateView()
            }
        }
    }

    private fun insertDatabase(user: List<PokemonEntity>) {
        viewModelScope.launch {
            insertLocalPokemonUseCase(user)
        }
    }
}