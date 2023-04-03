package com.ozgursarki.weatherapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryItem(
    val alpha3: String,
    val file_url: String,
    val license: String,
    val name: String,
    val url: String
): Parcelable