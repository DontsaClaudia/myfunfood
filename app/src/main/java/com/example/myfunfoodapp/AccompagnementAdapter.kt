package com.example.myfunfoodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class AccompagnementAdapter(private val accomp: MutableList<Accompagnement>,private val listner: Catalogue_menu )
    : RecyclerView.Adapter<AccompagnementAdapter.AccompagnementListViewHolder>() {
    class AccompagnementListViewHolder(itemView: View, listner: Catalogue_menu)
        :RecyclerView.ViewHolder(itemView) {
        var acomImage : CircleImageView = itemView.findViewById(R.id.accomp1)
        var acomName : TextView = itemView.findViewById(R.id.name_acomp)
        var acomChecked : CheckBox = itemView.findViewById(R.id.check2)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AccompagnementListViewHolder {
        val  view2 = LayoutInflater.from(parent.context).inflate(R.layout.acomp_item,parent, false)
        return AccompagnementAdapter.AccompagnementListViewHolder(view2, listner)

    }

    override fun onBindViewHolder(holder: AccompagnementListViewHolder, position: Int) {
        holder.acomImage.setImageResource(accomp[position].imgcom)
        holder.acomName.text = (accomp[position].namecom)
        holder.acomChecked.isChecked = (accomp[position].chekcom)
    }

    override fun getItemCount(): Int {
        return accomp.count()
    }
}