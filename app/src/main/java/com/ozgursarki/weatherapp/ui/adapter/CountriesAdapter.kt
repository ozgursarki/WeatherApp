package com.ozgursarki.weatherapp.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.weatherapp.domain.model.Country
import com.ozgursarki.weatherapp.domain.model.CountryItem
import com.ozgursarki.weatherapp.ui.adapter.viewholder.CountriesViewHolder

class CountriesAdapter (var countryList: Country = Country(), val itemClicked: (CountryItem) -> Unit) : RecyclerView.Adapter<CountriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(countryList[position]) {
            itemClicked.invoke(it)
        }
    }

    override fun getItemCount() = countryList.size

    fun setList(country: Country) {
        countryList = country
        notifyDataSetChanged()
    }
}