package com.ozgursarki.weatherapp.data.remote.dto

data class CityDTO(
    val current: Current,
    val location: Location,
    val request: Request
)