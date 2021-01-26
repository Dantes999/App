package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dataclasses.ManualStep
import com.example.myapplication.dataclasses.Plan

private val ITEM_VIEW_TYPE_HEADER = 0
private val ITEM_VIEW_TYPE_ITEM = 1

class PlanerRecyclerViewAdapter(private val planList: List<Plan>) :
    RecyclerView.Adapter<PlanerRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val planName: TextView
        val planTime: TextView
        val planImage: ImageView
        val planImage2: ImageView
        val headerTextView: TextView
        init {
            planName = view.findViewById(R.id.plan_name)
            planTime = view.findViewById(R.id.plan_time)
            planImage = view.findViewById(R.id.plan_image)
            planImage2 = view.findViewById(R.id.plan_image2)
            headerTextView = view.findViewById(R.id.tvHeader)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_plan_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentItem = planList[position]


        viewHolder.planName.text = currentItem.name
        viewHolder.planTime.text = currentItem.time
        viewHolder.planImage.setImageResource(currentItem.imageResource)
        viewHolder.planImage2.setImageResource(currentItem.imageResource2)
        viewHolder.headerTextView.text =  "  "+currentItem.category
        if (position > 0 ){
            val lastItem = planList[position - 1]
            if(lastItem.categoryId != currentItem.categoryId){
                viewHolder.headerTextView.visibility = View.VISIBLE
            } else {
                viewHolder.headerTextView.visibility = View.GONE
            }
        } else {
            viewHolder.headerTextView.visibility = View.VISIBLE
        }
    }

    override fun getItemCount() = planList.size
}
