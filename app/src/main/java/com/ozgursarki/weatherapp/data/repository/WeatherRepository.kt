package com.ozgursarki.weatherapp.data.repository

import com.ozgursarki.weatherapp.data.remote.WeatherAPI
import com.ozgursarki.weatherapp.data.remote.dto.CityDTO
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: WeatherAPI
)  {
    suspend fun getWeatherByCity (cityName : String) : CityDTO {
        return api.getWeatherInfo(query = cityName )
    }
}