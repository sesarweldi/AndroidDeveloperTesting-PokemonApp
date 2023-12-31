package com.well.testpokemonapp.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.well.testpokemonapp.R
import com.well.testpokemonapp.databinding.ActivityHomeBinding
import com.well.testpokemonapp.presentation.adapter.main.PokemonListAdapter
import com.well.testpokemonapp.presentation.base.BaseActivity
import com.well.testpokemonapp.presentation.listener.PokemonListener
import com.well.testpokemonapp.presentation.model.PokemonDataView
import com.well.testpokemonapp.presentation.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(), PokemonListener {
    private var adapter: PokemonListAdapter? = null
    private var recyclerViewLayoutManager: LinearLayoutManager? = null

    override fun getViewModelClass(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRecyclerView()
        initSearchBarView()
        observeViewModel()
        viewModel.getPokemon()
    }

    private fun observeViewModel() {
        viewModel.pokemonLiveData.observe(this::submitList)
        viewModel.clickPokemonItemEventLiveData.observe(this::navigateToDetail)
        viewModel.pokemonErrorLiveData.observe(this::onGetPokemonError)
    }

    private fun submitList(list: List<PokemonDataView>?) {
        list?.let {
            adapter?.setItemsAnimateChanges(list)
        }
    }

    private fun initRecyclerView() {
        viewBinding?.rvHome?.let { rv ->
            recyclerViewLayoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            adapter = PokemonListAdapter(this)

            rv.layoutManager = recyclerViewLayoutManager
            rv.adapter = adapter
        }
    }

    override fun onItemClicked(data: PokemonDataView) {
        viewModel.onItemPokemonClicked(data)
    }

    private fun navigateToDetail(data: PokemonDataView) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("name", data.name)
        startActivity(intent)
    }


    private fun onGetPokemonError(throwable: Throwable) {
        showSnackbar(throwable.message.toString())
    }

    private fun initSearchBarView() {
        viewBinding?.searchBar?.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText != "") filterData(newText ?: "")
                    else submitList(viewModel.pokemonList)
                    return false
                }
            })
            queryHint = "Search..."
        }
    }

    private fun filterData(query: String) {
       val filteredList = viewModel.pokemonList.filter {
           it.name?.contains(query, ignoreCase = true) == true
       }
        val sortedList = filteredList.sortedBy {
            it.name
        }
        adapter?.setItemsAnimateChanges(sortedList)
    }

}