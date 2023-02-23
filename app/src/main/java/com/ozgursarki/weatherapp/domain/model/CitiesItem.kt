package com.ozgursarki.weatherapp.domain.model

data class CitiesItem(
    val counties: List<String>,
    val latitude: String,
    val longitude: String,
    val name: String,
    val plate: String
)