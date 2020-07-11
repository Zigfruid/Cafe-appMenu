package com.example.fastfood.CafeeAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fastfood.R
import com.example.fastfood.data.ModelCafee.CafeMenu
import com.example.fastfood.data.ModelCafee.MenuClickListener
import com.example.fastfood.data.dao.MenuDao
import kotlinx.android.synthetic.main.rv_order_item.view.*
import kotlin.random.Random

class ChildAdapter(private val listener: MenuClickListener) : RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    var item: MutableList<CafeMenu> = mutableListOf()
    set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun removeAt(position: Int){
        item.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, item.size)
    }

    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ConnectWithDao {
        fun popModOrder(menu: CafeMenu, position: Int) {
            val a = Random.nextInt(1,10)
            itemView.tvItemOrderName.text = menu.nameRus
            itemView.tvCurier.text = "Курьер будет через $a мин"
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
            itemView.btnReOrder.setOnClickListener {
                removeAt(position)
            }
        }
        override fun removeFromOrder(cafeMenu: CafeMenu) {
            if (cafeMenu.isOrdered == 1) {
                cafeMenu.isOrdered = 1 - cafeMenu.isOrdered!!
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
            holder.popModOrder(item[position], position)
        }


}