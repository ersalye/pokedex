package dev.marcosfarias.pokedex.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.marcosfarias.pokedex.model.Item

@Dao
interface ItemDAO {
    @Query("SELECT * FROM item")
    fun all(): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(move: List<Item>?)
}