package com.mohamedhashim.circula.ui.component.pokemons

import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.findNavController
import com.mohamedhashim.circula.R
import com.mohamedhashim.circula.data.dto.Pokemon
import com.mohamedhashim.circula.databinding.FragmentPokemonDetailsBinding
import com.mohamedhashim.circula.databinding.FragmentPokemonListBinding
import com.mohamedhashim.circula.ui.base.DataBindingFragment
import com.mohamedhashim.circula.ui.base.bindings.bindAdapterPokemonsList
import com.mohamedhashim.circula.ui.component.pokemons.adapter.PokemonAdapter
import com.mohamedhashim.circula.ui.component.pokemons.viewholder.PokemonViewholder
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
class PokemonListFragment : DataBindingFragment(), PokemonViewholder.Delegate {

    private val viewModel: PokemonListViewModel by viewModel()
    private lateinit var binding: FragmentPokemonListBinding
    private val adapterPokemonList = PokemonAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = binding(
            inflater, R.layout.fragment_pokemon_list, container
        )
        return binding.apply {
            viewModel = this@PokemonListFragment.viewModel
            lifecycleOwner = this@PokemonListFragment
            adapter = PokemonAdapter(this@PokemonListFragment)
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showPokemons()
    }

    private fun showPokemons() {
        rvPokemons.removeAllViewsInLayout()
        viewModel.pokemonListLiveData.value?.let {
            adapterPokemonList.addPokemonsList(it)
        }
        bindAdapterPokemonsList(rvPokemons, viewModel.pokemonListLiveData.value)
    }

    override fun onItemClick(view: View, pokemon: Pokemon) {
        findNavController().navigate(
            R.id.actionPokemonDetails,
            PokemonListViewModel.createArguments(pokemon)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}