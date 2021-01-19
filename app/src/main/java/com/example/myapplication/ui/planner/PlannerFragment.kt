package com.example.myapplication.ui.planner

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.*
import com.example.myapplication.ui.recipes.RecipesViewModel
import kotlinx.android.synthetic.main.activity_recipes_list.*

class PlannerFragment : Fragment() {

    private lateinit var plannerViewModel: PlannerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        plannerViewModel =
            ViewModelProvider(this).get(PlannerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_planner, container, false)

        val examplePlans = generateDummyList()
        val recyclerView: RecyclerView = root.findViewById(R.id.planer_recycler_view)
        recyclerView.adapter = PlanerRecyclerViewAdapter(examplePlans)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        return root
    }
    private fun generateDummyList(): List<Plan> {
        val list = ArrayList<Plan>()

        val plan1 = Plan("Anstellgut",0,"Anstellgut", "1h 20min", R.drawable.ic_planer_icon, R.drawable.ic_planer_time)
        val plan1_1 = Plan("Anstellgut",0,"Anstellgut 2", "1h 20min", R.drawable.ic_planer_icon, R.drawable.ic_planer_time)
        val plan1_2 = Plan("Anstellgut",0,"Anstellgut 3", "1h 20min", R.drawable.ic_planer_icon, R.drawable.ic_planer_time)

        val plan2 = Plan("Sauerteigführung",1,"Salzsauer", "5h 20min", R.drawable.ic_planer_icon, R.drawable.ic_planer_time)
        val plan2_1 = Plan("Sauerteigführung",1,"Salzsauer 2", "5h 20min", R.drawable.ic_planer_icon, R.drawable.ic_planer_time)
        val plan3 = Plan("Brot",2,"Einfache Dreistufenführung", "0", R.drawable.ic_planer_icon, R.drawable.ic_planer_time)
        val plan3_1 = Plan("Brot",2,"Einfache Dreistufenführung 2", "0", R.drawable.ic_planer_icon, R.drawable.ic_planer_time)
        val plan3_2 = Plan("Brot",2,"Einfache Dreistufenführung 3", "0", R.drawable.ic_planer_icon, R.drawable.ic_planer_time)
        list += plan1
        list += plan1_1
        list += plan1_2
        list += plan2
        list += plan2_1
        list += plan3
        list += plan3_1
        list += plan3_2
        return list
    }
}