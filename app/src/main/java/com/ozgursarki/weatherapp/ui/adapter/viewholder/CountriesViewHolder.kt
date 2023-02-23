package com.ozgursarki.weatherapp.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ozgursarki.weatherapp.databinding.CountryRowBinding
import com.ozgursarki.weatherapp.domain.model.CountryItem
import com.ozgursarki.weatherapp.ui.extension.loadSvgOrOther

class CountriesViewHolder(private var binding: CountryRowBinding) : ViewHolder(binding.root) {

    fun bind(countryItem: CountryItem) {
        binding.countryName.text = countryItem.name
        //Picasso.with(binding.root.context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8s1EaDJ8SSS5Dv3hkC8Axdqw72hpd9k10gzC8Pg61bg&s").into(binding.imageView);
        binding.imageView.loadSvgOrOther("https:${countryItem.file_url}")
        binding.countryAlpha.text = countryItem.alpha3
    }

    companion object {
        fun create(
            parent: ViewGroup
        ) : CountriesViewHolder {
            val view = CountryRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return CountriesViewHolder(view)
        }
    }
}