package dev.marcosfarias.pokedex.ui.pokedex

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.item_pokemon.view.*
import java.util.*


class PokemonAdapter(
    private val list: List<Pokemon>,
    private val context: Context
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) {
            itemView.textViewName.text = item.name
            itemView.textViewID.text = item.id
            item.pokemonTypes?.getOrNull(0).let { firstType ->
                val firstTypeLowCase = firstType?.toLowerCase(Locale.ROOT)
                val imageInt1: Int = itemView.context.resources.getIdentifier(
                    firstTypeLowCase,
                    "drawable",
                    itemView.context.packageName
                )

                Glide.with(itemView.context)
                    .load(imageInt1)
                    .placeholder(R.drawable.grass)
                    .into(itemView.type1)
                itemView.type1.isVisible = firstType != null
            }

            item.pokemonTypes?.getOrNull(1).let { secondType ->
                itemView.type2.isVisible = secondType != null
                if (secondType != null) {
                    val secondTypeLowCase = secondType.toLowerCase(Locale.ROOT)
                val imageInt2: Int = itemView.context.resources.getIdentifier(
                    secondTypeLowCase,
                    "drawable",
                    itemView.context.packageName
                )

                Glide.with(itemView.context)
                    .load(imageInt2)
                    .placeholder(R.drawable.bug)
                    .into(itemView.type2)
                }
            }

            Glide.with(itemView.context)
                .load(item.image)
                .placeholder(android.R.color.transparent)
                .into(itemView.imageView)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_pokemon, parent, false)
        itemView.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                v.setBackgroundResource(R.drawable.with_selection_item)
            }
            if (event.action == MotionEvent.ACTION_UP || event.action == MotionEvent.ACTION_CANCEL) {
                v.setBackgroundColor(Color.TRANSPARENT)
            }
            false
        })
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
