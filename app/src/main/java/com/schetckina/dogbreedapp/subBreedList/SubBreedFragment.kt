package com.schetckina.dogbreedapp.subBreedList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.schetckina.dogbreedapp.databinding.FragmentSubBreedBinding


import com.schetckina.dogbreedapp.R
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 *
 */
class SubBreedFragment : Fragment() {

    private val viewModel: SubBreedViewModel by viewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSubBreedBinding>(inflater, R.layout.fragment_sub_breed, container, false)
        // Inflate the layout for this fragment

        Timber.i("onCreateView")
        binding.randomImageScreen.setOnClickListener { view -> view.findNavController().navigate(
            SubBreedFragmentDirections.actionSubBreedFragmentToBreedFragment(
                "cane corso"
            )
        ) }
        Timber.i("Called ViewModelProviders.of")
       // viewModel = ViewModelProviders.of(this, viewModelFactory).get(SubBreedViewModel::class.java)
        return binding.root
    }


}
