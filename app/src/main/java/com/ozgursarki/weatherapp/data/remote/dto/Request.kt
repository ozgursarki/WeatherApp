package com.ozgursarki.weatherapp.data.remote.dto

data class Request(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)