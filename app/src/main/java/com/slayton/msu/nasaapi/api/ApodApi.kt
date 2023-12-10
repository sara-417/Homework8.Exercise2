package com.slayton.msu.nasaapi.api

import retrofit2.http.GET

interface ApodApi {
    @GET("planetary/apod?" +
            "api_key=LtyBlzTvasC4iOjgkkP6fzd0AFUOLLt63soh9iKB" +
            "&count=10" +
            "&thumbs=false")
    suspend fun fetchPhotos(): List<GalleryItem>
}