package com.ozgursarki.weatherapp.ui.screen.detail

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ozgursarki.weatherapp.R
import com.ozgursarki.weatherapp.databinding.FragmentCityWeatherBinding
import com.ozgursarki.weatherapp.ui.extension.loadSvgOrOther
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
    ): View {
        binding = FragmentCityWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cityItem = args.cityItem
        viewModel.weatherInfo.observe(viewLifecycleOwner) { cityInfo ->
            binding.apply {
                address.text = cityInfo.request.query
                updatedAt.text = cityInfo.location.localtime
                weatherIcon.loadSvgOrOther(cityInfo.current.weather_icons[0])
                status.text = cityInfo.current.weather_descriptions[0]
                temp.text = "${cityInfo.current.temperature}°C"
                weatherFeelslike.text = "${cityInfo.current.feelslike}°C"
                windSpeed.text = cityInfo.current.wind_speed.toString()
                pressure.text = cityInfo.current.pressure.toString()
                humidity.text = cityInfo.current.humidity.toString()

                progressBar.visibility = View.VISIBLE

                Handler(Looper.getMainLooper()).postDelayed({

                    progressBar.visibility = View.INVISIBLE
                }, 500)







            }
        }

        viewModel.getWeatherByCityName(cityItem)



    }


}