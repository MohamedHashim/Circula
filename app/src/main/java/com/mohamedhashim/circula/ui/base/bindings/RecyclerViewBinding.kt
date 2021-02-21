package com.mohamedhashim.circula.ui.base.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mohamedhashim.circula.data.dto.Pokemon
import com.mohamedhashim.circula.ui.component.pokemons.adapter.PokemonAdapter
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.whatif.whatIfNotNullOrEmpty

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: BaseAdapter) {
    view.adapter = baseAdapter
}

@BindingAdapter("adapterPokemonsList")
fun bindAdapterPokemonsList(view: RecyclerView, pokemons: List<Pokemon>?) {
    pokemons.whatIfNotNullOrEmpty {
        val adapter = view.adapter as? PokemonAdapter
        adapter?.addPokemonsList(it)
    }
}