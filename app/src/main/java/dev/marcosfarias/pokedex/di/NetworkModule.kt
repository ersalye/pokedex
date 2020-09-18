package dev.marcosfarias.pokedex.di

import dev.marcosfarias.pokedex.repository.PokemonService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val pokemonURL = "https://app11.lifetimetech.vn/pokedex/"

val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(pokemonURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create<PokemonService>()
    }
}
