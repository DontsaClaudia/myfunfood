package com.example.myfunfoodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(private val person: ArrayList<Person>, private val listner: newprogram)
    : RecyclerView.Adapter<PersonAdapter.PersonsListViewHolder>() {
    class PersonsListViewHolder(itemView: View, listner: newprogram) : RecyclerView.ViewHolder(itemView) {

        var personNumber : TextView = itemView.findViewById(R.id.person)
        var personOld : TextView = itemView.findViewById(R.id.Old)
        var personWeight: TextView = itemView.findViewById(R.id.Weight)
        var personDishes: TextView = itemView.findViewById(R.id.Dishes)
        var personDay: TextView = itemView.findViewById(R.id.Days)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  PersonsListViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.members_item,parent, false)
        return  PersonsListViewHolder(view, listner)
    }

    override fun onBindViewHolder(holder: PersonsListViewHolder, position: Int) {

        holder.personNumber.text = "${(person[position].person_name.toString())} person(s)"
        holder.personOld.text = "${(person[position].old.toString())} years old"
        holder.personWeight.text = "${(person[position].weight.toString())} kg"
        holder.personDishes.text = "${(person[position].dishes_number.toString())} Dishes"
        holder.personDay.text = "${(person[position].day.toString())} Day(s)"
    }

    override fun getItemCount(): Int {
        return person.count()
    }

}




