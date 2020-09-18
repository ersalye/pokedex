package dev.marcosfarias.pokedex.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.marcosfarias.pokedex.model.Move
import dev.marcosfarias.pokedex.model.Pokemon

@Dao
interface MoveDAO {
    @Query ("SELECT * FROM move")
    fun all(): LiveData<List<Move>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(move: List<Move>?)
}