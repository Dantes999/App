package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecipesRecyclerViewAdapter(private val recipeList: List<Recipe>) :
    RecyclerView.Adapter<RecipesRecyclerViewAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recipeName: TextView
        val recipeTime: TextView
        val recipeDifficulty: TextView
        val recipeImage: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            recipeName = view.findViewById(R.id.recipe_name)
            recipeTime = view.findViewById(R.id.recipe_time)
            recipeDifficulty = view.findViewById(R.id.recipe_difficulty)
            recipeImage = view.findViewById(R.id.recipe_image)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recipe_list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentItem = recipeList[position]

        viewHolder.recipeName.text = currentItem.name
        viewHolder.recipeTime.text = currentItem.time
        viewHolder.recipeDifficulty.text = currentItem.difficulty
        viewHolder.recipeImage.setImageResource(currentItem.imageResource)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = recipeList.size

}
