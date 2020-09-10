package dev.marcosfarias.pokedex.ui.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.model.Pokemon

import kotlinx.android.synthetic.main.fragment_pokedex.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokedexFragment : Fragment() {

    private val pokedexViewModel: PokedexViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = recyclerView
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        pokedexViewModel.getListPokemon().observe(viewLifecycleOwner, Observer {
            val pokemons: List<Pokemon> = it
            recyclerView.adapter = PokemonAdapter(pokemons, view.context)
        })

        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_pokedex -> {

                    // Respond to navigation item 1 click

                    true
                }
                R.id.navigation_moves -> {
                    // Respond to navigation item 2 click
                    this.findNavController().navigate(R.id.action_navigation_pokedex_to_navigation_search)
                    true
                }
                R.id.navigation_itens -> {
                    // Respond to navigation item 3 click
                    true
                }
                else -> false
            }
        }
    }

}
