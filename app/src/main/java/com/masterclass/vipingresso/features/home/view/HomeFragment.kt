package com.masterclass.vipingresso.features.home.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.masterclass.vipingresso.databinding.FragmentHomeBinding
import com.masterclass.vipingresso.features.home.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it)[HomeViewModel::class.java]

            viewModel.command = MutableLiveData()

            viewModel.getEventSearch()

            viewModel.getAttractionSearch()





            setupObservables()
        }

    }

    private fun setupObservables() {


            viewModel.onSuccessEventSearchResult.observe(viewLifecycleOwner, {
                Log.i("teste", it.toString())
            })

            viewModel.onErrorEventSearchResult.observe(viewLifecycleOwner, {
                it
            })

            viewModel.onSuccessAttractionSearchResult.observe(viewLifecycleOwner,{
                it
            })

            viewModel.onErrorAttractionSearchResult.observe(viewLifecycleOwner,{
                it
            })
        }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}