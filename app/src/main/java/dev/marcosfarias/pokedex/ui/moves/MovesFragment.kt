package dev.marcosfarias.pokedex.ui.moves

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.model.Move
import kotlinx.android.synthetic.main.fragment_moves.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovesFragment: Fragment() {

    private val movesViewModel: MovesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_moves, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = move_recyclerView
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        movesViewModel.getListMove().observe(viewLifecycleOwner, Observer {
            val moves: List<Move> = it
            recyclerView.adapter = MovesAdapter(moves, view.context)
        })

    }
}