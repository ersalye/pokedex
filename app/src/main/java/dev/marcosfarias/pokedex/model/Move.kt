package dev.marcosfarias.pokedex.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import dev.marcosfarias.pokedex.utils.ListStringConverter

@Entity
@TypeConverters(ListStringConverter::class)
class Move {
    @PrimaryKey
    @NonNull
    var name: String? = null
    var type: String? = null
    var effect: String? = null
    var power: String? = null
    var accuracy: String? = null
    var pp: String? = null
}