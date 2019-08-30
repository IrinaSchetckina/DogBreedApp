package com.schetckina.dogbreedapp.randomImage


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

import com.schetckina.dogbreedapp.R
import com.schetckina.dogbreedapp.databinding.FragmentRandomImageBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 *
 */
class RandomImageFragment : Fragment() {

    private lateinit var viewModel: RandomImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentRandomImageBinding>(inflater, R.layout.fragment_random_image, container, false)
        binding.allImagesScreen.setOnClickListener { view -> view.findNavController().navigate(
            RandomImageFragmentDirections.actionBreedFragmentToBreedImagesFragment()) }
        setHasOptionsMenu(true)

        Timber.i("onCreateView")
        val args = arguments?.let { RandomImageFragmentArgs.fromBundle(it) }
        val defaultBreed = "default breed"
        Toast.makeText(context, "Current breed is ${args?.currentBreed ?: defaultBreed}", Toast.LENGTH_LONG).show()
        Timber.i("Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(RandomImageViewModel::class.java)
        return binding.root
    }

    private fun getShareIntent() : Intent {
        val args = arguments?.let { RandomImageFragmentArgs.fromBundle(it) }
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, "Current breed is ${args?.currentBreed}")
        return shareIntent
    }
     private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.isVisible = false
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }


}
