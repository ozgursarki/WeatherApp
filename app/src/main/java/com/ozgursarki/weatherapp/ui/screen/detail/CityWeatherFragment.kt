package com.ozgursarki.weatherapp.ui.screen.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ozgursarki.weatherapp.R
import com.ozgursarki.weatherapp.databinding.FragmentCityWeatherBinding
import com.ozgursarki.weatherapp.ui.extension.loadSvgOrOther
import com.ozgursarki.weatherapp.ui.screen.city.CitiesFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityWeatherFragment : Fragment() {
    private val viewModel: CityWeatherViewModel by viewModels()
    private lateinit var binding: FragmentCityWeatherBinding
    private val args: CityWeatherFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCityWeatherBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cityItem = args.cityItem
        viewModel.weatherInfo.observe(viewLifecycleOwner) { cityInfo ->
            binding.apply {
                cityName.text = cityInfo.location.name
                cityTimezone.text = cityInfo.location.timezone_id
                observationTime.text = cityInfo.current.observation_time
                binding.weaterIcon.loadSvgOrOther(cityInfo.current.weather_icons[0])
            }
        }

        viewModel.getWeatherByCityName(cityItem)
    }


}