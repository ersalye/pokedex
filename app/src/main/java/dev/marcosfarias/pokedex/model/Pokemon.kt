package dev.marcosfarias.pokedex.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import dev.marcosfarias.pokedex.utils.ListStringConverter

@Entity
@TypeConverters(ListStringConverter::class)
class Pokemon {
    @PrimaryKey
    @NonNull
    var name: String? = null
    var id: String? = null
    var image: String? = null
    var pokemonTypes: List<String>? = null
}