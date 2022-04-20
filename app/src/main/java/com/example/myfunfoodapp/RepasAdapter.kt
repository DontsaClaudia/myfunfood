package com.example.myfunfoodapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView


class RepasAdapter(private val repas: ArrayList<Repas>, private val listner: Catalogue_menu)
    :  RecyclerView.Adapter<RepasAdapter.RepasListViewHolder>() {
    class RepasListViewHolder(itemView: View, listner: Catalogue_menu) : RecyclerView.ViewHolder(itemView)
    {
        var repasImage : CircleImageView = itemView.findViewById(R.id.repas1)
        var repasName : TextView = itemView.findViewById(R.id.menu_name)
        var checked : CheckBox = itemView.findViewById(R.id.chek)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepasListViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item,parent, false)
        return RepasListViewHolder(view, listner)

    }

    override fun onBindViewHolder(holder: RepasListViewHolder, position: Int) {
        holder.repasImage.setImageResource(repas[position].imgrepas)
        holder.repasName.text = (repas[position].name)
        holder.checked.isChecked = (repas[position].check)
    }

    override fun getItemCount(): Int {
        return  repas.count()
    }

}