package com.schetckina.dogbreedapp.breedImages


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders

import com.schetckina.dogbreedapp.R
import com.schetckina.dogbreedapp.databinding.FragmentBreedImagesBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 *
 */
class BreedImagesFragment : Fragment() {

    private val viewModel: BreedImagesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentBreedImagesBinding>(inflater, R.layout.fragment_breed_images, container, false)

        Timber.i("onCreateView")
        return binding.root
    }


}
