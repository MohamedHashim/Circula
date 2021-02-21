package com.mohamedhashim.circula.ui.component.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohamedhashim.circula.R
import com.mohamedhashim.circula.data.dto.Pokemon
import com.mohamedhashim.circula.databinding.FragmentPokemonDetailsBinding
import com.mohamedhashim.circula.ui.base.DataBindingFragment

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
class PokemonDetailsFragment : DataBindingFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding<FragmentPokemonDetailsBinding>(
            inflater, R.layout.fragment_pokemon_details, container
        ).apply {
            pokemon = (requireArguments().get(getString(R.string.pokemon_key))) as Pokemon
        }.root
    }
}