package com.example.shareapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.shareapp.R
import com.example.shareapp.databinding.StoreFileFragmentBinding
import com.example.shareapp.view.tabLayout.TabManager
import com.example.shareapp.viewmodel.StoreFileViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class StoreFileFragment : Fragment() {

    private lateinit var binding: StoreFileFragmentBinding
    private lateinit var viewModel: StoreFileViewModel

    companion object {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.store_file_fragment,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = getViewModel()

        TabManager(
            viewModel = viewModel,
            tabLayout = binding.tabLayout,
        )

        viewModel.selectedFragment.observe(viewLifecycleOwner) {
            replaceFragment(it)
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(binding.frameTab.id, fragment)
        fragmentTransaction?.commit()
    }
}