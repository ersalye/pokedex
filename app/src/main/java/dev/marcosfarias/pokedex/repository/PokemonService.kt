package dev.marcosfarias.pokedex.repository

import dev.marcosfarias.pokedex.model.ItemsResponse
import dev.marcosfarias.pokedex.model.MovesResponse
import dev.marcosfarias.pokedex.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {
    @GET("api/v1/pokemons")
    fun getPokemon(): Call<PokemonResponse>

    @GET("api/v1/moves")
    fun getMove(): Call<MovesResponse>

    @GET("api/v1/items")
    fun getItem(): Call<ItemsResponse>
}
