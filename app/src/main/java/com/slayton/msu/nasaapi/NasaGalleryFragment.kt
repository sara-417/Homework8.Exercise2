package com.slayton.msu.nasaapi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.slayton.msu.nasaapi.api.ApodApi
import com.slayton.msu.nasaapi.databinding.FragmentNasaGalleryBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

private const val TAG = "NasaGalleryFragment"

class NasaGalleryFragment : Fragment() {
    private var _binding: FragmentNasaGalleryBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentNasaGalleryBinding.inflate(inflater, container, false)
        binding.photoGrid.layoutManager = GridLayoutManager(context, 3)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            val response = NasaRepository().fetchPhotos()
            Log.d(TAG, "Response received: $response")
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}