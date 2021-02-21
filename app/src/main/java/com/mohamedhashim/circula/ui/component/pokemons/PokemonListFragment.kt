package com.mohamedhashim.circula.ui.component.pokemons

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mohamedhashim.circula.R
import com.mohamedhashim.circula.data.dto.Pokemon
import com.mohamedhashim.circula.databinding.FragmentPokemonListBinding
import com.mohamedhashim.circula.ui.base.DataBindingFragment
import com.mohamedhashim.circula.ui.component.pokemons.adapter.PokemonAdapter
import com.mohamedhashim.circula.ui.component.pokemons.adapter.PokemonViewHolder
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
class PokemonListFragment : DataBindingFragment(), PokemonViewHolder.Delegate {

    private val viewModel: PokemonListViewModel by viewModel()

    //    private val pokemonDetailsViewModel: PokemonDetailsViewModel by viewModel()
    private val adapterPokemonList = PokemonAdapter(this)
//    private val args: PokemonListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding<FragmentPokemonListBinding>(
            inflater, R.layout.fragment_pokemon_list, container
        ).apply {
            viewModel = this@PokemonListFragment.viewModel
            lifecycleOwner = this@PokemonListFragment
            adapter = PokemonAdapter(this@PokemonListFragment)
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        loadMore()
//        observeMessages()
    }

    private fun initializeUI() {
        RecyclerViewPaginator(
            recyclerView = recyclerView,
            isLoading = { false },
            loadMore = { loadMore() },
            onLast = { false }
        )
    }

    private fun loadMore() = this.viewModel.pokemonListLiveData.value

//    private fun observeMessages() =
//        this.viewModel.toastLiveData.observe(viewLifecycleOwner, { context?.toast(it) })

    override fun onItemClick(view: View, pokemon: Pokemon) {
//        findNavController().navigate(
//            R.id.actionPokemonDetails,
//            MainViewModel.createArguments(pokemon)
//        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        (activity as AppCompatActivity).setSupportActionBar(view?.findViewById(R.id.topAppBar))

    }
}