package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.dataclasses.Ingredients
import com.example.myapplication.R

class IngredianceRecyclerViewAdapter (private val ingredientsList: List<Ingredients>) :
    RecyclerView.Adapter<IngredianceRecyclerViewAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ingredientsView: TextView
        val quantityView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            ingredientsView = view.findViewById(R.id.incredeance_name)
            quantityView = view.findViewById(R.id.incredeance_amount)
            imageView = view.findViewById(R.id.incredeance_image)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_incredeance_list, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentItem = ingredientsList[position]

        val amount = currentItem.amount.toString()
        val sb = StringBuilder()
        sb.append(amount).append(currentItem.unit)

        viewHolder.ingredientsView.text = currentItem.name
        viewHolder.quantityView.text = sb.toString()
        viewHolder.imageView.setImageResource(currentItem.imageResource)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = ingredientsList.size

}
