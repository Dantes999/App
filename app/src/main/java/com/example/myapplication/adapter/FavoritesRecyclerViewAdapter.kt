package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.dataclasses.Favorite
import com.example.myapplication.R

private val ITEM_VIEW_TYPE_HEADER = 0
private val ITEM_VIEW_TYPE_ITEM = 1

class FavoritesRecyclerViewAdapter(private val favList: List<Favorite>) :
    RecyclerView.Adapter<FavoritesRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val favName: TextView
        val favTime: TextView
        val favImage: ImageView
        val favGrade: TextView
        val headerTextView: TextView
        init {
            favName = view.findViewById(R.id.fav_name)
            favTime = view.findViewById(R.id.fav_time)
            favImage = view.findViewById(R.id.fav_image)
            favGrade = view.findViewById(R.id.fav_grade)
            headerTextView = view.findViewById(R.id.tvHeader)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fav_list_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentItem = favList[position]
        viewHolder.favName.text = currentItem.name
        viewHolder.favTime.text = currentItem.time
        viewHolder.favImage.setImageResource(currentItem.imageResource)
        viewHolder.favGrade.text = currentItem.grade
        viewHolder.headerTextView.text =  "  "+currentItem.category
        if (position > 0 ){
            val lastItem = favList[position-1]
            if(lastItem.categoryId != currentItem.categoryId){
                viewHolder.headerTextView.visibility = View.VISIBLE
            } else {
                viewHolder.headerTextView.visibility = View.GONE
            }
        } else {
            viewHolder.headerTextView.visibility = View.VISIBLE
        }
    }

    override fun getItemCount() = favList.size

}
