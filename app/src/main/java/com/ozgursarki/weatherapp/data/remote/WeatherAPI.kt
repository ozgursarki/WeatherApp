package com.ozgursarki.weatherapp.data.remote

import retrofit2.http.GET

interface WeatherAPI {
    companion object {
        const val BASE_URL = "https://weatherstack.com/"
    }
}