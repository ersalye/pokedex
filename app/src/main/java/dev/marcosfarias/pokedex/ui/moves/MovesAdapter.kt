package dev.marcosfarias.pokedex.ui.moves

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.model.Move
import dev.marcosfarias.pokedex.ui.pokedex.PokemonAdapter
import kotlinx.android.synthetic.main.item_moves.view.*
import java.util.*

class MovesAdapter(
    private val list: List<Move>,
    private val context: Context
) : RecyclerView.Adapter<MovesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Move) {
            itemView.name.text = item.name
            val type = item.type?.toLowerCase(Locale.ROOT)
            val imageInt: Int = itemView.context.resources.getIdentifier(
                type,
                "drawable",
                itemView.context.packageName
            )

            Glide.with(itemView.context)
                .load(imageInt)
                .placeholder(R.drawable.bug)
                .into(itemView.type)
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_moves, parent, false)
        itemView.setOnTouchListener(View.OnTouchListener { v, event ->
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