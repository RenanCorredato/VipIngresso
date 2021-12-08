package com.masterclass.vipingresso.features.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masterclass.vipingresso.R
import com.masterclass.vipingresso.databinding.WatchCardItemBinding
import com.masterclass.vipingresso.features.model.teste.model.Result


class AttractionSearchAdapter(
    private val attractionSearchList: List<Result>,
    private val onClickListener: (attractionSearch: Result) -> Unit
) : RecyclerView.Adapter<AttractionSearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WatchCardItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(attractionSearchList[position], onClickListener)
    }

    override fun getItemCount() = attractionSearchList.size

    class ViewHolder(
        private val binding: WatchCardItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            attractionSearch: Result,
            onClickListener: (attractionSearch: Result) -> Unit,
        ) {
            with(binding) {
                tvWatchTitle.text = attractionSearch.original_title
                tvWatchGenre.text = attractionSearch.title
                tvWatchTime.text = attractionSearch.release_date
                cvWatch.setOnClickListener {
                    onClickListener(attractionSearch)
                }
                Glide
                    .with(itemView.context)
                    .load(attractionSearch.poster_path)
                    .placeholder(R.drawable.no_image_availables)
                    .into(ivWatchImage)
            }
        }
    }
}