package com.ozgursarki.weatherapp.ui.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozgursarki.weatherapp.data.remote.dto.CityDTO
import com.ozgursarki.weatherapp.data.repository.WeatherRepository
import com.ozgursarki.weatherapp.domain.model.CitiesItem
import com.ozgursarki.weatherapp.domain.model.Country
import com.ozgursarki.weatherapp.domain.model.CountryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CityWeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _weatherInfo : MutableLiveData<CityDTO> = MutableLiveData()
    val weatherInfo : LiveData<CityDTO> = _weatherInfo


    fun getWeatherByCityName(cityItem: CitiesItem) {
        val cityDTO = repository.getWeatherByCity(cityItem.name)
        _weatherInfo.value = cityDTO
    }
}