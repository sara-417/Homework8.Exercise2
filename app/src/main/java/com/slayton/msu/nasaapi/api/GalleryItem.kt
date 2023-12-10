package com.slayton.msu.nasaapi.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryItem(
    // another problem i ran into was i tried to grab the hdurl
    // at first without realizing that not every image would
    // have this key.
    @Json(name = "url") val url: String,
    @Json(name = "title") val title: String,
)
