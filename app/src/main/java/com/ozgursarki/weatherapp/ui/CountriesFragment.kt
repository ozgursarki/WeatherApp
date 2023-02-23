package com.ozgursarki.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.weatherapp.R
import com.ozgursarki.weatherapp.domain.Country
import com.ozgursarki.weatherapp.ui.adapter.CountriesAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CountriesFragment : Fragment(){

    private val viewModel: CountriesViewModel by viewModels()
    private lateinit var adapter : CountriesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CountriesAdapter()
        val recyclerview = view.findViewById<RecyclerView>(R.id.countriesRv)
        recyclerview.adapter = adapter

        val countries = viewModel.getCountries()
        adapter.setList(countries)



    }

}