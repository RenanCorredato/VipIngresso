package com.masterclass.vipingresso.features.attractiondetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.masterclass.vipingresso.base.BaseViewModel
import com.masterclass.vipingresso.features.attractiondetails.usecase.DetailUseCase
import com.masterclass.vipingresso.features.model.teste.model.Movie
import kotlinx.coroutines.launch

class DetailViewModel:BaseViewModel() {

    private val detailUseCase = DetailUseCase()

    private val _onSuccessAttractionDetailsId: MutableLiveData<Movie> = MutableLiveData()
    val onSuccessAttractionDetailsId: LiveData<Movie>
        get() = _onSuccessAttractionDetailsId

    fun getAttractionDetailsId(movieId: Int) {
        viewModelScope.launch {
            callApi(
                suspend { detailUseCase.getAttractionDetailsId(movieId)},
                onSuccess = {
                    _onSuccessAttractionDetailsId.postValue(it as Movie)
                }
            )
        }
    }
}