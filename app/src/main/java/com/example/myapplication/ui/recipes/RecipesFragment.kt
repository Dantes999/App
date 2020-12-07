package com.example.myapplication.ui.recipes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.RecipesList
import kotlinx.android.synthetic.main.activity_recipes_list.*
import kotlinx.android.synthetic.main.fragment_recipes.*


class RecipesFragment : Fragment() {

    private lateinit var recipesViewModel: RecipesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recipesViewModel =
            ViewModelProvider(this).get(RecipesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_recipes, container, false)

        val card: CardView = root.findViewById(R.id.sourdough)
        card.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, RecipesList::class.java)
            startActivity(intent)
        })

        return root
    }
}