package com.schetckina.dogbreedapp.breedList

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.schetckina.dogbreedapp.R
import com.schetckina.dogbreedapp.databinding.BreedListFragmentBinding
import com.schetckina.dogbreedapp.model.enteties.Breed
import timber.log.Timber

class BreedListFragment: Fragment() {


    private lateinit var binding: BreedListFragmentBinding
    private val viewModel: BreedListViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.breed_list_fragment, container,false)
        Timber.i("onCreateView")

        val adapter = BreedsAdapter()
        binding.breedListView.adapter = adapter
        viewModel.getFreshData().observe(this, Observer {
            it?.let {
                Timber.i("Update data in adapter")
                adapter.data = it
                binding.refreshBreedList.isRefreshing = false
            }
        })
        binding.refreshBreedList.setOnRefreshListener {
            viewModel.getFreshData()
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun updateList(newBreedList: List<Breed>) {
        binding.refreshBreedList.isRefreshing = false

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun justLog() {
        Timber.i("on pause")
    }


}
