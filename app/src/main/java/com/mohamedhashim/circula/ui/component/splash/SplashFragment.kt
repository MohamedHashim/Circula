package com.mohamedhashim.circula.ui.component.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mohamedhashim.circula.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        GlobalScope.launch {
            delay(3000L)
            findNavController().navigate(
                R.id.pokemonListFragment
            )
        }
    }
}