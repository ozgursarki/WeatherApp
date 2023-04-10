package com.ozgursarki.weatherapp.data.remote

import com.ozgursarki.weatherapp.data.remote.dto.CityDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherAPI {
    companion object {
        const val BASE_URL = "http://api.weatherstack.com/"
    }

    @GET("current")
    suspend fun getWeatherInfo(
        @Query("access_key") access_key:String = "5dec92c75fe152690a4dd6bec8fdada9",
        @Query("query") query : String
    ) : CityDTO
}


