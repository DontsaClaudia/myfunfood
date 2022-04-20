package com.example.myfunfoodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfunfoodapp.databinding.ActivityCatalogueMenuBinding
import java.util.ArrayList
class Catalogue_menu : AppCompatActivity() {
    lateinit var recyclerViewRepas: RecyclerView
    val mails = arrayListOf(
        Repas(
            R.drawable.ndoles,"ndoles", false
        ),
        Repas(
            R.drawable.mbongo, "mbongo", true
        ),
        Repas(
            R.drawable.ikok,  "ikok", false
        ),
        Repas(
            R.drawable.gombo, "sauce gombo", true
        ),
        Repas(
            R.drawable.eru, "eru aux peaux", true
        ),
        Repas(
            R.drawable.hache_tomate, "sauce tomate hache", true
        ),
        Repas(
            R.drawable.haricot, "haricot saute", true
        ),
        Repas(
            R.drawable.pistache, "pistache saute", true
        )
    )
    var accompagnements = mutableListOf(
        Accompagnement(
            R.drawable.ikok, "manioc", true
        ),
        Accompagnement(
            R.drawable.gombo, "couscous", true
        ),
        Accompagnement(
            R.drawable.mbongo, "couscous_manioc", false
        ),
        Accompagnement(
            R.drawable.ndoles, "macabos", true
        ),
    )

    private val adapter2 = AccompagnementAdapter(accompagnements ,this)
    private val adapter1 = RepasAdapter(mails, this)
    private  lateinit var newrecycleview: RecyclerView
    private lateinit var newarraylist: ArrayList<Accompagnement>
    private  lateinit var tempArrayList: ArrayList<Accompagnement>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogue_menu)
        recyclerViewRepas = findViewById(R.id.recycleview_repas)
        recyclerViewRepas!!.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewRepas.adapter = adapter1

        val recyclerView2 = findViewById<RecyclerView>(R.id.recycleview2)
        val layout =  LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView2!!.layoutManager = layout
        recyclerView2.adapter = adapter2



    }


}
