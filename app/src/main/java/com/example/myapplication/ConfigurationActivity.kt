package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.IngredianceRecyclerViewAdapter
import com.example.myapplication.adapter.StepByStepRecyclerViewAdapter
import com.example.myapplication.dataclasses.Ingredients
import com.example.myapplication.dataclasses.StepByStep
import kotlinx.android.synthetic.main.activity_configuration.*
import java.math.BigInteger


class ConfigurationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)
        setTitle("Sauerteig Führung");
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var exampleInc = generateIncDummyList(1000)
        val exampleSteps = generateStepsDummyList()

        val editText: EditText = findViewById<EditText>(R.id.TextEditInput)
        editText.setText("1000")
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val editText: EditText = findViewById<EditText>(R.id.TextEditInput)
                if(editText.getText().length > 3){
                    exampleInc = generateIncDummyList(editText.getText().toString().trim().toInt())
                    incredeance_recyclerview.adapter = IngredianceRecyclerViewAdapter(exampleInc)
                }
            }
        })
        incredeance_recyclerview.adapter = IngredianceRecyclerViewAdapter(exampleInc)
        incredeance_recyclerview.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        incredeance_recyclerview.setHasFixedSize(true)

        startrecipebutton.setOnClickListener{
            startActivity(Intent(this, ManualActivity::class.java))
        }
        stepbystep_recyclerview.adapter = StepByStepRecyclerViewAdapter(exampleSteps)
        stepbystep_recyclerview.layoutManager = LinearLayoutManager(this)
        stepbystep_recyclerview.setHasFixedSize(true)
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

    private fun generateIncDummyList(amount : Int): List<Ingredients> {

        val list = ArrayList<Ingredients>()
        val ingr1 = Ingredients("Mehlmenge", (amount/2), "g", R.drawable.ic_mehl )
        val ingr2 = Ingredients("Wassermenge", (amount/2),"ml", R.drawable.ic_wassertropfen )
        val ingr3 = Ingredients("Anstellgut", (amount/80), "g", R.drawable.ic_starter )
        val ingr4 = Ingredients("Wasser Temperatur", 34, "°C", R.drawable.ic_thermometer )
        list += ingr1
        list += ingr2
        list += ingr3
        list += ingr4

        return list
    }

}