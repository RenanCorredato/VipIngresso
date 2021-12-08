package com.masterclass.vipingresso.features.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masterclass.vipingresso.databinding.FragmentHomeBinding
import com.masterclass.vipingresso.features.home.adapter.AttractionSearchAdapter
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

            viewModel.getAttractionSearch()




            setupObservables()


        }

    }

    private fun setupObservables() {
        viewModel.onSuccessAttractionSearch.observe(viewLifecycleOwner, {
         it?.let {attractionSearch ->
             val attractionSearchAdapter = AttractionSearchAdapter(
                 attractionSearchList = attractionSearch
             ){
                 viewModel.getAttractionDetailsId(it.id)
             }
             binding?.let{
                 with(it){
                     rvHomeEventSearch.apply {
                         layoutManager = LinearLayoutManager(context)
                         adapter = attractionSearchAdapter
                     }
                 }
             }
         }

        })

        viewModel.onErrorAttractionSearch.observe(viewLifecycleOwner, {
            it
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}