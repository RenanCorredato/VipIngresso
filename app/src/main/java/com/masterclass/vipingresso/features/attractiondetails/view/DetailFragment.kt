package com.masterclass.vipingresso.features.attractiondetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.masterclass.vipingresso.base.BaseFrament
import com.masterclass.vipingresso.databinding.FragmentDetailBinding
import com.masterclass.vipingresso.features.attractiondetails.viewmodel.DetailViewModel
import com.masterclass.vipingresso.utils.Command
import com.masterclass.vipingresso.utils.ConstantsApp.Home.KEY_BUNDLE_MOVIE_ID


class DetailFragment : BaseFrament() {

    private var binding: FragmentDetailBinding? = null

    private val movieId: Int by lazy {
        arguments?.getInt(KEY_BUNDLE_MOVIE_ID)?:-1
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel =  ViewModelProvider(it)[DetailViewModel::class.java]

            viewModel.command = command

            viewModel.getAttractionDetailsId(movieId)

            setupObservervalbles()
        }

    }


    private fun setupObservervalbles() {
        viewModel.onSuccessAttractionDetailsId.observe(viewLifecycleOwner,{
            it.let { movie ->
                binding?.let {bindingNoNull->
                    with(bindingNoNull){
                        activity?.let { activityNoNull->
                           Glide.with(activityNoNull)
                               .load(movie.backdrop_path)
                               .into(ivMovieDetailsPosterImage)
                        }

                        tvMovieDetailsDescriptionText.text = movie.overview
                        tvMovieDetailSynopsisText.text = movie.original_title
                    }
                }
            }
        })

        viewModel.command.observe(viewLifecycleOwner,{
            when(it){
                is Command.Loading ->{

                }
                is Command.Error ->{

                }
            }
        })

        binding?.btMovieDetailsBackIcon?.setOnClickListener {
            activity?.onBackPressed()
        }
        binding?.btMovieDetailNearbyTheaters?.setOnClickListener {
          Toast.makeText(context,"Tente novamente mais tarde",Toast.LENGTH_LONG).show()
        }
    }

    override  var command: MutableLiveData<Command> = MutableLiveData()

}