package com.ozgursarki.weatherapp.ui

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.ozgursarki.weatherapp.domain.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    val country: Country
): ViewModel() {

    fun getCountries() : Country {
        return country
    }
}