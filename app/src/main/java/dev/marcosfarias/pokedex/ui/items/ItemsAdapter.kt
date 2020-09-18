package dev.marcosfarias.pokedex.ui.items

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.model.Item
import dev.marcosfarias.pokedex.model.Move
import kotlinx.android.synthetic.main.item_items.view.*
import kotlinx.android.synthetic.main.item_moves.view.*
import java.util.*

class ItemsAdapter(
    private val list: List<Item>,
    private val context: Context
) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Item) {
            itemView.item_name.text = item.name
            itemView.price.text = item.price.toString()
            val image = item.image
            Glide.with(itemView.context)
                .load(image)
                .placeholder(R.drawable.beast_ball)
                .into(itemView.image_item)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_items, parent, false)
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