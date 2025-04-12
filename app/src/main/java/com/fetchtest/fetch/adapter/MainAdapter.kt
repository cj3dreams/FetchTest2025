package com.fetchtest.fetch.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fetchtest.fetch.model.MainModel

class MainAdapter (private val list: List<MainModel>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = list.size

}