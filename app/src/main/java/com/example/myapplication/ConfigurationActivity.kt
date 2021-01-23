package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.adapter.IngredianceRecyclerViewAdapter
import com.example.myapplication.dataclasses.Ingredients
import kotlinx.android.synthetic.main.configuration_activity.*

class ConfigurationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)
        setTitle("Sauerteig Führung");
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val exampleInc = generateIncDummyList()
        val exampleSteps = generateStepsDummyList()

       incredeance_recyclerview.adapter = IngredianceRecyclerViewAdapter(exampleInc)
       incredeance_recyclerview.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
       incredeance_recyclerview.setHasFixedSize(true)

//        stepbystep_recyclerview.adapter = StepByStepRecyclerViewAdapter(exampleSteps)
//        stepbystep_recyclerview.layoutManager = LinearLayoutManager(this)
//        stepbystep_recyclerview.setHasFixedSize(true)
    }

    private fun generateStepsDummyList(): List<StepByStep> {

        val list1 = ArrayList<StepByStep>()
        val stepone = StepByStep("1. Stufe     Anfrischsauer", "Schritt 1", "Schritt 2", "", "4 bis 5h  Stehzeit",
            "Gib 50g Anstellgut, 80g Mehl und 80ml Wasser in eine Schüssel",
            "Vermenge die Zutaten miteinander",
            "",
            "Teigtemperatur: 24 bis 26 °C\\n\" +\n" +
                    "                \"Teigausbeute: 200",
            R.drawable.img_addingr,
            R.drawable.img_mix,
            R.drawable.img_mix,
            R.drawable.img_timer
            )
        val steptwo = StepByStep("1. Stufe     Anfrischsauer", "Schritt 1", "Schritt 2", "", "4 bis 5h  Stehzeit",
            "Gib 50g Anstellgut, 80g Mehl und 80ml Wasser in eine Schüssel",
            "Vermenge die Zutaten miteinander",
            "",
            "Teigtemperatur: 24 bis 26 °C\\n\" +\n" +
                    "                \"Teigausbeute: 200",
            R.drawable.img_addingr,
            R.drawable.img_mix,
            R.drawable.img_mix,
            R.drawable.img_timer
        )
        val stepthree = StepByStep("1. Stufe     Anfrischsauer", "Schritt 1", "Schritt 2", "", "4 bis 5h  Stehzeit",
            "Gib 50g Anstellgut, 80g Mehl und 80ml Wasser in eine Schüssel",
            "Vermenge die Zutaten miteinander",
            "",
            "Teigtemperatur: 24 bis 26 °C\\n\" +\n" +
                    "                \"Teigausbeute: 200",
            R.drawable.img_addingr,
            R.drawable.img_mix,
            R.drawable.img_mix,
            R.drawable.img_timer
        )
        list1 +=stepone
        list1 +=steptwo
        list1 +=stepthree

        return list1
    }

    private fun generateIncDummyList(): List<Ingredients> {

        val list = ArrayList<Ingredients>()
        val ingr1 = Ingredients("Mehlmenge", 1200, "g", R.drawable.ic_mehl )
        val ingr2 = Ingredients("Wassermenge", 1200, "ml", R.drawable.ic_wassertropfen )
        val ingr3 = Ingredients("Anstellgut", 50, "g", R.drawable.ic_starter )
        val ingr4 = Ingredients("Wasser Temperatur", 34, "°C", R.drawable.ic_thermometer )
        list += ingr1
        list += ingr2
        list += ingr3
        list += ingr4

        return list
    }

}