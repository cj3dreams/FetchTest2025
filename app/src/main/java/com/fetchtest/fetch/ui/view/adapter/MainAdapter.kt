package com.fetchtest.fetch.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fetchtest.fetch.R
import com.fetchtest.fetch.data.model.MainModel

class MainAdapter (private val list: List<MainModel>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(view: View): RecyclerView.ViewHolder(view){

        val itemIdTx: TextView = view.findViewById(R.id.itemIdTx)
        val itemListIdTx: TextView = view.findViewById(R.id.itemListIdTx)
        val itemNameTx: TextView = view.findViewById(R.id.itemNameTx)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val itemData = list[position]
        holder.itemIdTx.text = itemData.id.toString()
        holder.itemListIdTx.text = itemData.listId.toString()
        holder.itemNameTx.text = itemData.name

    }

    override fun getItemCount() = list.size

}