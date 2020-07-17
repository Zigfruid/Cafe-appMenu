package com.example.fastfood.CafeeAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fastfood.R
import com.example.fastfood.data.ModelCafee.CafeMenu
import com.example.fastfood.data.ModelCafee.MenuClickListener
import kotlinx.android.synthetic.main.rv_item.view.*

class MainAdapter(private val listener: MenuClickListener): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var item: List<CafeMenu> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun popMod(menu: CafeMenu) {
            itemView.tvItemProductName.text = menu.nameRus
           itemView.tvItemProductCost?.text = "${menu.cost} руб"
            val imageResName = "picture${menu.id}"
            Glide
                .with(itemView)
                .load(itemView.context.resources
                    .getIdentifier(imageResName, "drawable", itemView.context.packageName))
                .into(itemView.ivItemPhoto)
            itemView.setOnClickListener {
                listener.onItemMenuClickListener(menu.id)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
      val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return MainViewHolder(itemView)
    }

    override fun getItemCount(): Int {
     return item.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.popMod(item[position])
    }
}