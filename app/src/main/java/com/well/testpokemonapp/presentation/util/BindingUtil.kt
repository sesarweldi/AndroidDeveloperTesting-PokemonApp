package com.well.testpokemonapp.presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.well.testpokemonapp.R

object BindingUtil {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun bindImageUrl(view: ImageView, url: String?) {
        val loader = CircularProgressDrawable(view.context).apply {
            strokeWidth = 10f
            centerRadius = 40f
            start()
        }

        val option = RequestOptions()
            .placeholder(R.drawable.img_placeholder)
            .error(loader)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)

        try {
            Glide.with(view.context)
                .setDefaultRequestOptions(option)
                .load(url)
                .into(view)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}