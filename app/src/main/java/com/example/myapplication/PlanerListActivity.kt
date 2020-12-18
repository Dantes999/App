package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_planer_list.*
import kotlinx.android.synthetic.main.activity_recipes_list.*

class PlanerListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planer_list)
        setTitle("Planer");
        val examplePlans = generateDummyList()



        planer_recycler_view.adapter = PlanerRecyclerViewAdapter(examplePlans)
        planer_recycler_view.layoutManager = LinearLayoutManager(this)
        planer_recycler_view.setHasFixedSize(true)
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
