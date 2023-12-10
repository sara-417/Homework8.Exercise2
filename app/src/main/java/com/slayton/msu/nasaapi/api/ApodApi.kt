package com.slayton.msu.nasaapi.api

import retrofit2.http.GET

interface ApodApi {
    @GET("planetary/apod?" +
            "api_key=LtyBlzTvasC4iOjgkkP6fzd0AFUOLLt63soh9iKB" +
            "&count=75")
/*the thumbs param, when set to false is prevents
the url of a video from being returned, i thought
that this meant that videos would be ignored, but
videos still popped up but had a blank square. */
    suspend fun fetchPhotos(): List<GalleryItem>

//    maps direcly to the GalleryItem class because, with how
//    i have things set up there is no need to map to the response
//    classes that we had in chapter 20

//    The difference in this Json data compared to the Flickr Json
//    is that there is not a wrapping key that contains the photo
//    data. So there is no need to map to the PhotoResponse class
//    to try and grab a "photo" key.

//    furthermore there is no paging data contained in the photos
//    grabbed from Apod. becuase there is no paging data I was
//    unsure how paging was meant to implemented in this
//    assignment. I played around with adding wrapping keys to
//    the Json I recieve from the website, but was unsuccessful
//    in my attempts. This also ate up a lot of time which put
//    me in a time crunch for the rest of the funcitonalities.
}