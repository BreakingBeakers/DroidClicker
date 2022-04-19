package com.example.droidclicker

import android.content.Context
import android.view.LayoutInflater
import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView

class Clicker_RecyclerViewAdapter(context:Context, clickerList: ArrayList<ClickerTile>) :
    RecyclerView.Adapter<Clicker_RecyclerViewAdapter.MyViewHolder>() {

    var context:Context = context
    var clickerList: ArrayList<ClickerTile> = clickerList

    //This is where you inflate your layout (Giving a look to our rows)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Clicker_RecyclerViewAdapter.MyViewHolder {
        var inflator: LayoutInflater = from(context)
        var view:View = inflator.inflate(R.layout.clicker_tile, parent, false)
        return Clicker_RecyclerViewAdapter.MyViewHolder(view)
    }

    //assigning values to the views we created in the recycler_view_row layout file
    //based on the position of the recycler view
    override fun onBindViewHolder(holder: Clicker_RecyclerViewAdapter.MyViewHolder, position: Int) {
        var clicker:ClickerTile = clickerList[position]
        holder.tapButton.setOnClickListener {
            clicker.tapButton()
            holder.pointBar.progress = clicker.progress
        }
        holder.pointBar.progress = clickerList.get(position).progress
    }

    //the recycler view just wants to know the number of items you want displayed
    override fun getItemCount(): Int {
        return clickerList.size
    }

    //Kinda like an onCreate() method
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tapButton: Button = itemView.findViewById(R.id.tapButtonCard)
        var upgradeButton: Button = itemView.findViewById(R.id.upgradeButtonCard)
        var managerButton: Button = itemView.findViewById(R.id.managerButtonCard)
        var pointBar: ProgressBar = itemView.findViewById(R.id.pointBar)
    }
}