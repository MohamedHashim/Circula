package com.mohamedhashim.circula.ui.base.bindings

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mohamedhashim.circula.R

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */

@BindingAdapter("pokemonSrc")
fun ImageView.bindPokemonSrc(imagePath: String) {
    Glide.with(this.context)
        .load(imagePath)
        .error(ContextCompat.getDrawable(this.context, R.drawable.ic_not_found))
        .into(this)
}
