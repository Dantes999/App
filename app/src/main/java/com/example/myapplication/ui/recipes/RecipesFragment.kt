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
import com.example.myapplication.RecipesListActivity
import com.google.android.material.snackbar.Snackbar


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
        val sourdoughcard: CardView = root.findViewById(R.id.sourdough)
        sourdoughcard.setOnClickListener(View.OnClickListener {
            startActivity(Intent(activity, RecipesListActivity::class.java))
        })
        val breadcard: CardView = root.findViewById(R.id.bread)
        breadcard.setOnClickListener(View.OnClickListener {
            //startActivity(Intent(activity, RecipesListActivity::class.java))
            Snackbar.make(breadcard, "Kommt noch", Snackbar.LENGTH_SHORT).show()
        })
        val startercard: CardView = root.findViewById(R.id.starter)
        startercard.setOnClickListener(View.OnClickListener {
            //startActivity(Intent(activity, RecipesListActivity::class.java))
            Snackbar.make(startercard, "Kommt auch noch", Snackbar.LENGTH_SHORT).show()
        })
        return root
    }
}