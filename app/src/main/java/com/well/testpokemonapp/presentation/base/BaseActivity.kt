package com.well.testpokemonapp.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar


abstract class BaseActivity<ViewBinding : ViewDataBinding, ViewModel : androidx.lifecycle.ViewModel> :
    AppCompatActivity() {

    private var _viewBinding: ViewBinding? = null

    protected val viewModel: ViewModel by lazy { ViewModelProvider(this)[getViewModelClass()] }

    protected val viewBinding
        get() = _viewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _viewBinding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }

    abstract fun getViewModelClass(): Class<ViewModel>

    abstract fun getLayoutId(): Int

    fun <T> LiveData<T>.observe(observer: Observer<in T>) {
        observe(this@BaseActivity, observer)
    }

    fun showSnackbar(message: String) {
        val snackbar = Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_SHORT
        )
        snackbar.show()
    }

}