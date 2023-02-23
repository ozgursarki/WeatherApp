package com.ozgursarki.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.weatherapp.R
import com.ozgursarki.weatherapp.domain.Country
import com.ozgursarki.weatherapp.domain.CountryItem
import com.ozgursarki.weatherapp.ui.adapter.viewholder.CountriesViewHolder
import javax.inject.Inject

class CountriesAdapter (var countryList: Country = Country()) : RecyclerView.Adapter<CountriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_row,parent,false)
        return CountriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(countryList[position])
    }

    override fun getItemCount() = countryList.size

    fun setList(country: Country) {
        countryList = country
        notifyDataSetChanged()
    }
}