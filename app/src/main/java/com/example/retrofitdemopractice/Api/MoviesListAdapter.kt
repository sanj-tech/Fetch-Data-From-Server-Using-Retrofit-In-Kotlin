package com.example.retrofitdemopractice.Api

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitdemopractice.R

class MoviesListAdapter(var context: Context, var moviesList: MutableList<Movie>) :
    RecyclerView.Adapter<MoviesListAdapter.RecyclerViewList>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewList {
        val view =
            LayoutInflater.from(context).inflate(R.layout.recyclerview_list_item, parent, false)
        return RecyclerViewList(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewList, position: Int) {

        holder.name.text = moviesList[position].moviesName
        Glide.with(context)
            .load(moviesList[position].moviesPic)
            //.placeholder(R.drawable.pdf)
            .into(holder.profilePic)

    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class RecyclerViewList(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profilePic = itemView.findViewById<ImageView>(R.id.ivProfilePic)
        var name = itemView.findViewById<TextView>(R.id.empName)

    }


}