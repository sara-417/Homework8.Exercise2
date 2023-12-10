package com.slayton.msu.nasaapi.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApodResponse(
    val photos: List<GalleryItem>
)