package com.example.fastfood.CafeeAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fastfood.R
import com.example.fastfood.data.ModelCafee.CafeMenu
import com.example.fastfood.data.ModelCafee.MenuClickListener
import kotlinx.android.synthetic.main.rv_order_item.view.*
import kotlin.random.Random

class ChildAdapter(private val listener: MenuClickListener) : RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    var item: List<CafeMenu> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun popModOrder(menu: CafeMenu) {
            val a = Random.nextInt(10)
            itemView.tvItemOrderName.text = menu.nameRus
            itemView.tvCurier.text = "Курьер будет через $a мин"
            //itemView.tvQuantity.text = " "
            val imageResName = "picture${menu.id}"
            Glide
                .with(itemView)
                .load(
                    itemView.context.resources
                        .getIdentifier(imageResName, "drawable", itemView.context.packageName)
                )
                .into(itemView.ivItemOrderPhoto)
            itemView.setOnClickListener {
                    listener.onItemMenuClickListener(menu.id)
            }
        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
            val itemView: View =
                LayoutInflater.from(parent.context).inflate(R.layout.rv_order_item, parent, false)
            return ChildViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return item.size
        }

        override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
            holder.popModOrder(item[position])
        }

}