package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recipes_list.*

class RecipesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes_list)
        setTitle("Sauerteig Führung");
        val exampleRecipes = generateDummyList()

        sourdough_recycler_view.adapter = RecipesRecyclerViewAdapter(exampleRecipes)
        sourdough_recycler_view.layoutManager = LinearLayoutManager(this)
        sourdough_recycler_view.setHasFixedSize(true)
    }

    private fun generateDummyList(): List<Recipe> {

        val list = ArrayList<Recipe>()
        val recipe1 = Recipe("Einstufiger Sauerteig", "1h 20min", "einfach", R.drawable.ic_recipe)
        val recipe2 = Recipe("Zweistufiger Sauerteig", "5h 20min", "mittel", R.drawable.ic_starter)
        val recipe3 = Recipe("Dreistufiger Sauerteig", "12h 20min", "schwer", R.drawable.ic_favorite_24px)
        list += recipe1
        list += recipe2
        list += recipe3

        return list
    }

}