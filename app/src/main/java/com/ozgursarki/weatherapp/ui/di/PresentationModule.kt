package com.ozgursarki.weatherapp.ui.di

import android.content.Context
import com.google.gson.Gson
import com.ozgursarki.weatherapp.R
import com.ozgursarki.weatherapp.domain.model.Cities
import com.ozgursarki.weatherapp.domain.model.Country
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        val gsonBuilder = Gson().newBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideCountries(
        @ApplicationContext
        context: Context,
        gson:Gson
    ): Country {
        try {
            val reader = BufferedReader(
                InputStreamReader(
                    context.applicationContext
                        .resources
                        .openRawResource(R.raw.countries)
                )
            )
            val fromJson = gson.fromJson(reader, Country::class.java)
            return fromJson
        } catch (e: Exception) {
            throw e
        }
    }

    @Provides
    @Singleton
    fun provideCities(
        @ApplicationContext
        context: Context,
        gson:Gson
    ): Cities {
        try {
            val reader = BufferedReader(
                InputStreamReader(
                    context.applicationContext
                        .resources
                        .openRawResource(R.raw.cities)
                )
            )
            val fromJson = gson.fromJson(reader, Cities::class.java)
            return fromJson
        } catch (e: Exception) {
            throw e
        }
    }
}