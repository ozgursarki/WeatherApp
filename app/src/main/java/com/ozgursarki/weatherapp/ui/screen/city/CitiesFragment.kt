package com.ozgursarki.weatherapp.ui.screen.city

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozgursarki.weatherapp.R
import com.ozgursarki.weatherapp.databinding.FragmentCitiesBinding
import com.ozgursarki.weatherapp.domain.model.Cities
import com.ozgursarki.weatherapp.domain.model.CitiesItem
import com.ozgursarki.weatherapp.ui.adapter.CitiesAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.List

@AndroidEntryPoint
class CitiesFragment : Fragment() {
    private lateinit var binding: FragmentCitiesBinding
    private val viewModel : CitiesViewModel by viewModels()
    private lateinit var newList : List<Cities>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCitiesBinding.inflate(inflater,container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



            val adapter = CitiesAdapter(cityClicked = {
                val action = CitiesFragmentDirections.actionCitiesFragmentToCityWeatherFragment(it)
                findNavController().navigate(action)
            })
            binding.citiesRv.adapter = adapter

            val list = viewModel.getCities()
            adapter.setCityList(list)


        val mDividerItemDecoration = DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL)
        with(binding.citiesRv) {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            addItemDecoration(mDividerItemDecoration)
        }

        binding.citySearchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val list = viewModel.getCities()
                adapter.setCityList(list)
                adapter.searchChange(newText!!)
                return true
            }

        })

        viewModel.getCities()



    }

}