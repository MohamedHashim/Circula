package com.mohamedhashim.circula.ui.component.pokemons.adapter

import android.view.View
import com.mohamedhashim.circula.R
import com.mohamedhashim.circula.data.dto.Pokemon
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
class PokemonAdapter (
    private val delegate: PokemonViewHolder.Delegate
) : BaseAdapter() {

    init {
        addSection(ArrayList<Pokemon>())
    }

    fun addPokemonList(pokemons: List<Pokemon>) {
        val section = sections()[0]
        section.addAll(pokemons)
        notifyItemRangeInserted(section.size - pokemons.size + 1, pokemons.size)
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_pokemon

    override fun viewHolder(layout: Int, view: View) = PokemonViewHolder(view, delegate)
}