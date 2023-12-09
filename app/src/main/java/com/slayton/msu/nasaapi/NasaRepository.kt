package com.slayton.msu.nasaapi

import com.slayton.msu.nasaapi.api.ApodApi
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

class NasaRepository {
    private val apodApi: ApodApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        apodApi = retrofit.create()
    }

    suspend fun fetchPhotos() = apodApi.fetchPhotos()


}