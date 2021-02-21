package com.mohamedhashim.circula.ui.component.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mohamedhashim.circula.R
import com.mohamedhashim.circula.data.dto.Pokemon
import com.mohamedhashim.circula.databinding.FragmentPokemonDetailsBinding
import com.mohamedhashim.circula.ui.base.DataBindingFragment
import kotlinx.android.synthetic.main.fragment_pokemon_details.*

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
class PokemonDetailsFragment : DataBindingFragment() {

    private lateinit var binding: FragmentPokemonDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = binding(
            inflater, R.layout.fragment_pokemon_details, container
        )
        return binding.apply {
            pokemon = (requireArguments().get(getString(R.string.pokemon_key))) as Pokemon
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(toolbar, activity as AppCompatActivity)
    }

    private fun initToolbar(toolbar: Toolbar, activity: AppCompatActivity) {
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.title = ""
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // clear views references to fix memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}