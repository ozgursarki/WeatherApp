package com.ozgursarki.weatherapp.ui.screen.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozgursarki.weatherapp.R
import com.ozgursarki.weatherapp.ui.adapter.CountriesAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

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
        recyclerview.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)

        val countries = viewModel.getCountries()
        adapter.setList(countries)

        val list = ArrayList<String>()

        val locales: Array<String> = Locale.getISOCountries()

        for (countryCode in locales) {
            val obj = Locale("", countryCode)
            System.out.println("Country Name = " + obj.getDisplayCountry())
            list.add(obj.getDisplayCountry())
        }
        print("x")
    }

}