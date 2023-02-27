package com.ozgursarki.weatherapp.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.weatherapp.domain.model.Cities
import com.ozgursarki.weatherapp.domain.model.CitiesItem
import com.ozgursarki.weatherapp.ui.adapter.viewholder.CitiesViewHolder

class CitiesAdapter(private var cityList : Cities = Cities(), val cityClicked : (CitiesItem) -> Unit) : RecyclerView.Adapter<CitiesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        return CitiesViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        holder.bind(cityList[position]) {
            cityClicked.invoke(it)
        }
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    fun setCityList(newList: Cities) {
        cityList = newList
        notifyDataSetChanged()
    }
}