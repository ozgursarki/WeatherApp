package com.ozgursarki.weatherapp.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ozgursarki.weatherapp.databinding.CityRowBinding
import com.ozgursarki.weatherapp.domain.model.CitiesItem

class CitiesViewHolder(private val binding: CityRowBinding) : ViewHolder(binding.root) {

    fun bind(cityItem : CitiesItem,cityClicked : (CitiesItem) -> Unit) {
        binding.city = cityItem
        binding.root.setOnClickListener {
            cityClicked.invoke(cityItem)
        }
    }

    companion object {
        fun create(parent: ViewGroup) : CitiesViewHolder {
            val view = CityRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return CitiesViewHolder(view)
        }
    }
}