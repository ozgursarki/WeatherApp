package com.ozgursarki.weatherapp.ui.screen.city

import androidx.lifecycle.ViewModel
import com.ozgursarki.weatherapp.domain.model.Cities
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val cities: Cities
) : ViewModel() {
    fun getCities() : Cities {
        return cities
    }
}