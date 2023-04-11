package com.ozgursarki.weatherapp.data.remote.dto

data class Current(
    val cloudcover: Float,
    val feelslike: Float,
    val humidity: Float,
    val is_day: String,
    val observation_time: String,
    val precip: Float,
    val pressure: Float,
    val temperature: Float,
    val uv_index: Float,
    val visibility: Float,
    val weather_code: Float,
    val weather_descriptions: List<String>,
    val weather_icons: List<String>,
    val wind_degree: Float,
    val wind_dir: String,
    val wind_speed: Float
)