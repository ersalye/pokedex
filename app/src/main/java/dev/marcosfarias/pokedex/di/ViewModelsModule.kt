package dev.marcosfarias.pokedex.di

import dev.marcosfarias.pokedex.ui.pokedex.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { PokedexViewModel(get(), get()) }
}
