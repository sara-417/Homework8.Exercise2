package com.slayton.msu.nasaapi.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoResponse(
    @Json(name = "title") val galleryItems: List<GalleryItem>
)
