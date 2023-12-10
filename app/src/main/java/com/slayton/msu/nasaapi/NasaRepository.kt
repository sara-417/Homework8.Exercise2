package com.slayton.msu.nasaapi

import com.slayton.msu.nasaapi.api.ApodApi
import com.slayton.msu.nasaapi.api.GalleryItem
import com.slayton.msu.nasaapi.api.PhotoResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class NasaRepository {
    private val apodApi: ApodApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(MoshiConverterFactory.create())
//            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        apodApi = retrofit.create()
    }

    //    suspend fun fetchPhotos() = apodApi.fetchPhotos()
    suspend fun fetchPhotos(): List<GalleryItem> =
        apodApi.fetchPhotos()
}

