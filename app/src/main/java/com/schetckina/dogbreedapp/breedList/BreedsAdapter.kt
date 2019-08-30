package com.schetckina.dogbreedapp.breedList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.schetckina.dogbreedapp.R
import com.schetckina.dogbreedapp.model.enteties.Breed

class BreedsAdapter: RecyclerView.Adapter<TextItemViewHolder>() {


    var data = listOf<Breed>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.breed_item_holder, parent, false) as TextView
        return TextItemViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = if (item.parentBreed != null)  "${item.label} ${item.parentBreed}" else item.label
    }



}

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
