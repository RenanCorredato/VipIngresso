package com.masterclass.vipingresso.features.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.masterclass.vipingresso.R
import com.masterclass.vipingresso.base.BaseFrament
import com.masterclass.vipingresso.databinding.FragmentHomeBinding
import com.masterclass.vipingresso.features.home.adapter.AttractionSearchAdapter
import com.masterclass.vipingresso.features.home.viewmodel.HomeViewModel
import com.masterclass.vipingresso.utils.Command
import com.masterclass.vipingresso.utils.ConstantsApp.Home.KEY_BUNDLE_MOVIE_ID


class HomeFragment : BaseFrament() {

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

            viewModel.command = command

            viewModel.getAttractionSearch()


            setupObservables()


        }

    }

    private fun setupObservables() {
        viewModel.onSuccessAttractionSearch.observe(viewLifecycleOwner, {
            it?.let { attractionSearch ->
                val attractionSearchAdapter = AttractionSearchAdapter(
                    attractionSearchList = attractionSearch
                ) {
                    // viewModel.getAttractionDetailsId(it.id)
                    val bundle = Bundle()
                    bundle.putInt(KEY_BUNDLE_MOVIE_ID,it.id)
                    findNavController(
                    ).navigate(R.id.action_homeFragment_to_detailFragment,bundle)

                }
                binding?.let {
                    with(it) {
                        rvHomeEventSearch.apply {
                            layoutManager = LinearLayoutManager(context)
                            adapter = attractionSearchAdapter
                        }
                        rvHomeEventSearch.adapter?.stateRestorationPolicy = RecyclerView
                            .Adapter.StateRestorationPolicy
                            .PREVENT_WHEN_EMPTY
                    }
                }
            }

        })

        viewModel.onErrorAttractionSearch.observe(viewLifecycleOwner, {
            it
        })

        viewModel.command.observe(viewLifecycleOwner, {
            when (it) {
                is Command.Loading -> {

                }
                is Command.Error ->
                    binding?.let { bindingNonNull ->
                        Snackbar.make(
                            bindingNonNull.rvHomeEventSearch,
                            getString(it.error),
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }

            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override var command: MutableLiveData<Command> = MutableLiveData()


}