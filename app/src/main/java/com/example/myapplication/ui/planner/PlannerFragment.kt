package com.example.myapplication.ui.planner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R

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
        val textView: TextView = root.findViewById(R.id.text_notifications)
        plannerViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}