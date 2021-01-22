package com.example.myapplication.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.google.android.material.slider.RangeSlider


class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        val SliderText : TextView = root.findViewById(R.id.RangeSliderText)
        val slider: RangeSlider = root.findViewById(R.id.slider)
        slider.setValues(1.0f, 5.0f)
        slider.addOnChangeListener { slider, value, fromUser ->
            val vals = slider.values
            SliderText.setText("%.2f".format(vals[0]).toString()+" Uhr bis "+"%.2f".format(vals[1]).toString()+" Uhr")
        }
        return root
    }

}