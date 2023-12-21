package com.well.testpokemonapp.presentation.ui.detail

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.well.testpokemonapp.R
import com.well.testpokemonapp.databinding.ActivityDetailBinding
import com.well.testpokemonapp.presentation.adapter.main.AbilityPokemonDetailAdapter
import com.well.testpokemonapp.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    private var adapter: AbilityPokemonDetailAdapter? = null
    private var recyclerViewLayoutManager: GridLayoutManager? = null
    override fun getViewModelClass(): Class<DetailViewModel> {
        return DetailViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        viewModel.getPokemonDetail()
        observeViewModel()
        initRecycler()
    }

    private fun observeViewModel() {
        viewModel.pokemonDetailLiveData.observe(this::submitList)
        viewModel.pokemonErrorLiveData.observe(this::onGetPokemonError)
    }

    private fun initViewModel() {
        viewBinding?.data = viewModel
        viewModel.name.set(intent.getStringExtra("name"))
    }

    private fun initRecycler() {
        viewBinding?.rvAbility?.let { rv ->
            recyclerViewLayoutManager =
                GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
            adapter = AbilityPokemonDetailAdapter()

            rv.layoutManager = recyclerViewLayoutManager
            rv.adapter = adapter
        }
    }

    private fun onGetPokemonError(throwable: Throwable) {
        showSnackbar(throwable.message.toString())
    }

    private fun submitList(itemList: List<String>) {
        adapter?.setItemsAnimateChanges(itemList)
    }
}