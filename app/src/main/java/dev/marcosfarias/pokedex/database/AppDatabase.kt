package dev.marcosfarias.pokedex.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.marcosfarias.pokedex.database.dao.ItemDAO
import dev.marcosfarias.pokedex.database.dao.MoveDAO
import dev.marcosfarias.pokedex.database.dao.PokemonDAO
import dev.marcosfarias.pokedex.model.Item
import dev.marcosfarias.pokedex.model.Move
import dev.marcosfarias.pokedex.model.Pokemon

@Database(entities = [Pokemon::class, Move:: class, Item:: class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDAO(): PokemonDAO
    abstract fun moveDAO(): MoveDAO
    abstract fun itemDAO(): ItemDAO
}
