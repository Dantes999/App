package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.ManualRecyclerviewAdapter
import com.example.myapplication.dataclasses.ManualStep

class ManualFragment : Fragment() {

    companion object {
        fun newInstance() = ManualFragment()
    }

    private lateinit var viewModel: ManualViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_manual, container, false)

        val exampleManual = generateDummyList()
        val recyclerView: RecyclerView = root.findViewById(R.id.manualrecyclerview)
        recyclerView.adapter = ManualRecyclerviewAdapter(exampleManual)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ManualViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun generateDummyList(): ArrayList<ManualStep> {
        val list = ArrayList<ManualStep>()

        val stepone = ManualStep(
            "Schritt 1",
            "Gib 50g Anstellgut, 80g Mehl und 80ml Wasser in eine Schüssel",
            R.drawable.img_addingr
        )
        val steptwo = ManualStep(
            "Schritt 2",
            "Vermenge die Zutaten miteinander",
            R.drawable.img_mix
        )
        val stepthree = ManualStep(
            "Schritt 3",
            "Teigtemperatur: 24 bis 26 °C\\n\" +\n" + "\"Teigausbeute: 200",
            R.drawable.img_timer
        )

        list += stepone
        list += steptwo
        list += stepthree

        return list
    }

}