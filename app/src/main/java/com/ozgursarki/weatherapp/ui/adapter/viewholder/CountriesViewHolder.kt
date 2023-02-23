package com.ozgursarki.weatherapp.ui.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ozgursarki.weatherapp.R
import com.ozgursarki.weatherapp.domain.CountryItem

class CountriesViewHolder(itemView: View) : ViewHolder(itemView) {
    fun bind(countryItem: CountryItem) {
        itemView.findViewById<TextView>(R.id.countryName).text = countryItem.name
    }
}