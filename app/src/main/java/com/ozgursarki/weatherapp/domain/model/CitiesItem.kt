package com.ozgursarki.weatherapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CitiesItem(
    val counties: List<String>,
    val latitude: String,
    val longitude: String,
    val name: String,
    val plate: String
) : Parcelable