package com.example.myapplication.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.HomeActivity
import com.example.myapplication.R
import com.example.myapplication.adapter.ManualRecyclerviewAdapter
import com.example.myapplication.dataclasses.ManualStep
import kotlinx.android.synthetic.main.fragment_manual.*
import pl.droidsonroids.gif.GifImageView


class ManualFragment : Fragment(), ManualRecyclerviewAdapter.OnItemClickListener {
    val exampleManual = generateDummyList()
    var currentPosition: Int = 0


    companion object {
        fun newInstance() = ManualFragment()
    }

    private lateinit var viewModel: ManualViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_manual, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.manualrecyclerview)
        recyclerView.adapter = ManualRecyclerviewAdapter(exampleManual, this)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)


        val gifImageView: GifImageView = root.findViewById(R.id.manualGif)
        val textView: TextView = root.findViewById(R.id.manualInstructions)
        val button: Button = root.findViewById(R.id.nextstepbutton)

        gifImageView.setImageResource(exampleManual[currentPosition].gifResource)
        textView.text = exampleManual[currentPosition].description
        button.setOnClickListener {
            if (currentPosition < (exampleManual.size-1)) {
                currentPosition++
                gifImageView.setImageResource(exampleManual[currentPosition].gifResource)
                textView.text = exampleManual[currentPosition].description
            }else {
                requireActivity().run{
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
            }
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ManualViewModel::class.java)

    }

    override fun onItemClick(position: Int) {
        currentPosition = position
        val clickedItem = exampleManual[position]
        manualInstructions.text = clickedItem.description
        manualGif.setImageResource(clickedItem.gifResource)
    }

    private fun generateDummyList(): ArrayList<ManualStep> {
        val list = ArrayList<ManualStep>()

        val stepone = ManualStep(
            "Schritt 1",
            "Gib 50g Anstellgut, 80g Mehl und 80ml Wasser in eine Schüssel",
            R.drawable.img_addingr,
            R.drawable.gif_addingr
        )
        val steptwo = ManualStep(
            "Schritt 2",
            "Vermenge die Zutaten miteinander",
            R.drawable.img_mix,
            R.drawable.gif_mix
        )
        val stepthree = ManualStep(
            "Schritt 3",
            "Teigtemperatur: 24 bis 26 °C\\n\" +\n" + "\"Teigausbeute: 200",
            R.drawable.img_timer,
            R.drawable.gif_timer
        )

        list += stepone
        list += steptwo
        list += stepthree

        return list
    }

}