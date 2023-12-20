package com.well.testpokemonapp.presentation.ui.detail

import com.well.testpokemonapp.R
import com.well.testpokemonapp.databinding.ActivityDetailBinding
import com.well.testpokemonapp.presentation.base.BaseActivity

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    override fun getViewModelClass(): Class<DetailViewModel> {
        return DetailViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_detail
    }
}