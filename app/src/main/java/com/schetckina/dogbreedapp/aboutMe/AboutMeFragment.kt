package com.schetckina.dogbreedapp.aboutMe


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.schetckina.dogbreedapp.R
import com.schetckina.dogbreedapp.databinding.FragmentAboutMeBinding
import timber.log.Timber


class AboutMeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =  DataBindingUtil.inflate<FragmentAboutMeBinding>(inflater, R.layout.fragment_about_me, container, false)

        Timber.i("onCreateView")
        return binding.root
    }


}
