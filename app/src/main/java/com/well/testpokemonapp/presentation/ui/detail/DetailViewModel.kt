package com.well.testpokemonapp.presentation.ui.detail

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.well.testpokemonapp.domain.entity.PokemonDetailEntity
import com.well.testpokemonapp.domain.params.GetPokemonDetailParam
import com.well.testpokemonapp.domain.usecases.main.GetPokemonDetailUseCase
import com.well.testpokemonapp.presentation.model.DataViewMapper.toPokemonDetailDataView
import com.well.testpokemonapp.presentation.model.PokemonDetailDataView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {


    val name: ObservableField<String> = ObservableField()
    val picture: ObservableField<String> = ObservableField()
    val heightString: ObservableField<String> = ObservableField("0 cm")
    val weightString: ObservableField<String> = ObservableField("0 kg")


    private val abilityList = mutableListOf<String>()

    private val _pokemonDetailLiveData = MutableLiveData<List<String>>()
    val pokemonDetailLiveData: LiveData<List<String>>
        get() = _pokemonDetailLiveData

    private val _pokemonDetailErrorLiveData = MutableLiveData<Throwable>()
    val pokemonErrorLiveData: LiveData<Throwable>
        get() = _pokemonDetailErrorLiveData


    fun getPokemonDetail() {
        executeGetPokemonUseCase()
    }

    private fun executeGetPokemonUseCase() {
        getPokemonDetailUseCase.execute(
            ::onGetPokemonDetailSuccess,
            ::onGetPokemonDetailFailed,
            getPokemonDetailParam()
        )
    }

    private fun getPokemonDetailParam(): GetPokemonDetailParam {
        return GetPokemonDetailParam(
            name = name.get() ?: ""
        )
    }

    private fun onGetPokemonDetailSuccess(data: PokemonDetailEntity) {
        name.set(data.name)
        picture.set(data.picture)
        heightString.set(data.height?.times(10).toString() + " cm")
        weightString.set(data.weight?.div(10).toString() + " kg")
        createAbilityList(data.toPokemonDetailDataView())
        updateView()
    }

    private fun createAbilityList(data: PokemonDetailDataView?) {
        abilityList.clear()
        abilityList.addAll(data?.abilities ?: listOf())
    }

    private fun updateView() {
        _pokemonDetailLiveData.postValue(abilityList)
    }

    private fun onGetPokemonDetailFailed(throwable: Throwable) {
        _pokemonDetailErrorLiveData.postValue(throwable)
    }
}