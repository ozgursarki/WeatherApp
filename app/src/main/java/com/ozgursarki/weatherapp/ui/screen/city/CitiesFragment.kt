package com.ozgursarki.weatherapp.ui.screen.city

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozgursarki.weatherapp.R
import com.ozgursarki.weatherapp.databinding.FragmentCitiesBinding
import com.ozgursarki.weatherapp.ui.adapter.CitiesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitiesFragment : Fragment() {
    private lateinit var binding: FragmentCitiesBinding
    private val viewModel : CitiesViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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



    }
}