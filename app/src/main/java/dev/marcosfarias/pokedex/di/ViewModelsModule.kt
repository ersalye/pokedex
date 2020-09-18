package dev.marcosfarias.pokedex.di

import dev.marcosfarias.pokedex.ui.items.ItemsViewModel
import dev.marcosfarias.pokedex.ui.moves.MovesViewModel
import dev.marcosfarias.pokedex.ui.pokedex.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { PokedexViewModel(get(), get()) }
    viewModel { MovesViewModel(get(), get()) }
    viewModel { ItemsViewModel(get(), get()) }
}
