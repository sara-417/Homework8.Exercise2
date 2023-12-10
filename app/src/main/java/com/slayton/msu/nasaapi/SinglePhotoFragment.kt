package com.slayton.msu.nasaapi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import coil.load
import com.slayton.msu.nasaapi.databinding.FragmentNasaGalleryBinding
import com.slayton.msu.nasaapi.databinding.FragmentSinglePhotoBinding

class SinglePhotoFragment : Fragment() {
    private var _binding: FragmentSinglePhotoBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

//    grab the arguments passed on navigation
    private val args: SinglePhotoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        use those arguments to set the properties of the fragments' views
//        issue i encountered: i tried to do this in the adapter at first for
//        some reason and that obviously didnt work
        binding.imageDisplay.load(args.photoUrl)
        binding.imageTitle.text = args.photoTitle
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentSinglePhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}