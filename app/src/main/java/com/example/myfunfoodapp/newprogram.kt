package com.example.myfunfoodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfunfoodapp.databinding.ActivityNewprogramBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.selects.whileSelect

class newprogram : AppCompatActivity() {
        private lateinit var binding: ActivityNewprogramBinding
        private var famille = arrayListOf( familly("NGUESSONG"))
         private lateinit var data : DatabaseReference

    private var persons = arrayListOf(
        Person("NGUESSONG","18","50.0F","2","7"),
        Person("MENDJIN","20","62.2F","2","7"),
        Person("DONTSA","10","35.0F","2","7"),
        Person("ESSONO","25","55.0F","2","7")
    )
    private val adapter = PersonAdapter(persons, this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newprogram)
        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener{
            var intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        val button8 = findViewById<Button>(R.id.button8)
        button8.setOnClickListener {
            var  intent = Intent(this, Catalogue_menu::class.java)
            startActivity(intent)
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val list = findViewById<RecyclerView>(R.id.recyclerView)
        val layout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        list!!.layoutManager = layout
        list.adapter = adapter

        val floatingbtn1 = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        floatingbtn1.setOnClickListener {
            val mDialogView1 = LayoutInflater.from(this).inflate(R.layout.activity_dialogaddfamily, null)
            val mBuilder1 = AlertDialog.Builder(this)
            mBuilder1.setView(mDialogView1)
            val mAlertDialog = mBuilder1.show()
            val cancel = mDialogView1.findViewById<TextView>(R.id.textView22)
            val save = mDialogView1.findViewById<TextView>(R.id.textView21)
            cancel.setOnClickListener {
                mAlertDialog.dismiss()
            }
            save.setOnClickListener {
                val famil = mDialogView1.findViewById<TextInputLayout>(R.id.textInputLayout9).toString()
                famille.add(familly(famil))
            }
        }
        val floatingbtn2 = findViewById<ImageView>(R.id.imageView9)
        floatingbtn2.setOnClickListener {
            val mDialogView2 = LayoutInflater.from(this).inflate(R.layout.activity_dialog_add_person, null)
            val mBuilder2 = AlertDialog.Builder(this)
            mBuilder2.setView(mDialogView2)
            val mAlertDialog = mBuilder2.show()
            val cancel = mDialogView2.findViewById<TextView>(R.id.cancel)
            val save2 = mDialogView2.findViewById<TextView>(R.id.save)
            cancel.setOnClickListener {
                mAlertDialog.dismiss()
            }
            save2.setOnClickListener {
                val person_name = mDialogView2.findViewById<TextInputLayout>(R.id.person_name).placeholderText.toString()
                val old = mDialogView2.findViewById<TextView>(R.id.old).text.toString()
                val weight = mDialogView2.findViewById<TextView>(R.id.Weight).text.toString()
                val dishes = mDialogView2.findViewById<TextView>(R.id.dish).text.toString()
                val day = mDialogView2.findViewById<TextView>(R.id.days).text.toString()
                persons.add(Person(person_name, old, weight, dishes, day))


            }
        }


        /*binding = ActivityNewprogramBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button8.setOnClickListener {
            val namefamilly = binding.name.toString()
            val startdate = binding.textInputLayout15.toString()
            val endDate = binding.end.toString()
            val person = binding.pers.toString()
            val montant = binding.fcfa.toString()
            val days = binding.days.toString()
            val dish = binding.dish.toString()

            data = FirebaseDatabase.getInstance().getReference("Add program")
            val AddProgram =AddProgram(namefamilly, startdate, endDate, person, montant, days, dish )
            data.child(namefamilly).setValue(AddProgram).addOnSuccessListener {
                binding.name.toString()
                binding.textInputLayout15.toString()
                binding.end.toString()
                binding.pers.toString()
                binding.fcfa.toString()
                binding.dish.toString()

                Toast.makeText(this, "Succesfully", Toast.LENGTH_LONG).show()


            }.addOnFailureListener{
                Toast.makeText(this, "Failled", Toast.LENGTH_LONG).show()
            }
        }*/

        }



}


