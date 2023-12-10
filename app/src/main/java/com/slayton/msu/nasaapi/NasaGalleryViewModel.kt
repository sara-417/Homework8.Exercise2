package com.slayton.msu.nasaapi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayton.msu.nasaapi.api.GalleryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// i pretty much just modeled this after what we did in the Flickr App.
private const val TAG = "NasaGalleryViewModel"
class NasaGalleryViewModel : ViewModel() {
    private val photoRepository = NasaRepository()
    private val _galleryItems: MutableStateFlow<List<GalleryItem>> =
        MutableStateFlow(emptyList())
    val galleryItems: StateFlow<List<GalleryItem>>
        get() = _galleryItems.asStateFlow()
    init {
        viewModelScope.launch {
            try {
                val items = photoRepository.fetchPhotos()
                _galleryItems.value = items
            } catch (ex: Exception) {
                Log.e(TAG, "Failed to fetch gallery items", ex)
            }
        }
    }
//got from chatGPT
    fun refreshData() {
        viewModelScope.launch {
            try {
                val items = photoRepository.fetchPhotos()
                _galleryItems.value = items
            } catch (ex: Exception) {
                Log.e(TAG, "Failed to fetch gallery items", ex)
            }
        }
    }
}
