package com.example.fastfood.CafeeAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fastfood.R

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var item: List<MenuCafee> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun popMod() {

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