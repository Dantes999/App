package com.example.myapplication.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.*

class FavoritesFragment : Fragment() {

    private lateinit var favoritesViewModel: FavoritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoritesViewModel =
            ViewModelProvider(this).get(FavoritesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_favorites, container, false)
        val exampleFav = generateDummyList()
        val recyclerView: RecyclerView = root.findViewById(R.id.favorites_recycler_view)
        recyclerView.adapter = FavoritesRecyclerViewAdapter(exampleFav)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        return root
    }
    private fun generateDummyList(): List<Favorite> {
        val list = ArrayList<Favorite>()

        val Fav1 = Favorite("Sauerteigführung",0,"Salzsauer", "1 Tag 02:00h", R.drawable.ic_favorite_icon, "Einfach")
        val Fav1_1 = Favorite("Sauerteigführung",0,"Detmolden Einstufenführung", "04:00h", R.drawable.ic_favorite_icon, "Mittel")
        val Fav1_2 = Favorite("Sauerteigführung",0,"Einfache Dreistufenführung", "06:00h", R.drawable.ic_favorite_icon, "Mittel")

        val Fav2 = Favorite("Brot",1,"Roggenbrot", "1 Tag 02:00h", R.drawable.ic_favorite_icon, "Einfach")
        val Fav2_1 = Favorite("Brot",1,"Berliner Kastenbrot", "20:00h", R.drawable.ic_favorite_icon, "Schwer")

        list += Fav1
        list += Fav1_1
        list += Fav1_2
        list += Fav2
        list += Fav2_1

        return list
    }
}