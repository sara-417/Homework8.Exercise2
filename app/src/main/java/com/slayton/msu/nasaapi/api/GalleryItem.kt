package com.slayton.msu.nasaapi.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryItem(
    @Json(name = "url") val url: String,
    @Json(name = "title") val title: String,
)
