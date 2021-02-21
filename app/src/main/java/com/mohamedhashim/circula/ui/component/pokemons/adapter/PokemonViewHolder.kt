package com.mohamedhashim.circula.ui.component.pokemons.adapter

import android.view.View
import androidx.core.view.ViewCompat
import com.mohamedhashim.circula.data.dto.Pokemon
import com.mohamedhashim.circula.databinding.ItemPokemonBinding
import com.mohamedhashim.circula.ui.base.bindings
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import timber.log.Timber

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
class PokemonViewHolder(
    view: View,
    private val delegate: Delegate
) : BaseViewHolder(view) {

    interface Delegate {
        fun onItemClick(view: View, pokemon: Pokemon)
    }

    private lateinit var pokemon: Pokemon
    private val binding by bindings<ItemPokemonBinding>(view)

    override fun bindData(data: Any) {
        if (data is Pokemon) {
            pokemon = data
            binding.apply {
                ViewCompat.setTransitionName(binding.itemPokemonContainer, data.imagePath)
                pokemon = data
                executePendingBindings()
            }
        }
    }

    override fun onClick(v: View?) = delegate.onItemClick(binding.itemPokemonContainer, pokemon)

    override fun onLongClick(v: View?): Boolean = true
}
